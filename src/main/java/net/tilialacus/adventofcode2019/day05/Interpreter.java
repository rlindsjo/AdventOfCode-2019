package net.tilialacus.adventofcode2019.day05;

public class Interpreter {
    private final int[] mem;
    private int instructionPointer;
    private boolean halted;
    private int input;
    private String output = "";

    public Interpreter(int[] mem) {
        this.mem = mem;
    }

    public long get(int i) {
        return mem[i];
    }

    public int read(int address) {
        return mem[address];
    }

    public void write(int address, int value) {
        mem[address] = value;
    }

    public void input(int input) {
        this.input = input;
    }

    public String output() {
        return output;
    }

    public void run() {
        instructionPointer = 0;
        halted = false;
        while (!halted) {
            step();
        }
    }

    protected void step() {
        Instruction instruction;
        switch (opCode() % 100) {
            case 1:
                instruction = ADD;
                break;
            case 2:
                instruction = MUL;
                break;
            case 3:
                instruction = SET;
                break;
            case 4:
                instruction = OUT;
                break;
            case 5:
                instruction = JNZ;
                break;
            case 6:
                instruction = JZ;
                break;
            case 7:
                instruction = LT;
                break;
            case 8:
                instruction = EQ;
                break;
            case 99:
                instruction = HALT;
                break;
            default:
                throw new IllegalStateException("Unknown opcode " + instructionPointer + " " + mem[instructionPointer]);
        }
        instruction.process();
        instructionPointer += instruction.size();
    }

    private int opCode() {
        return read(instructionPointer);
    }

    private final Instruction ADD = new Instruction3Op() {
        @Override
        public void process() {
            write(p3(true), p1() + p2());
        }
    };

    private  final Instruction MUL = new Instruction3Op() {
        @Override
        public void process() {
            write(p3(true), p1() * p2());
        }
    };

    private  final Instruction SET = new Instruction1Op() {
        @Override
        public void process() {
            write(p1(true), input);
        }
    };

    private  final Instruction OUT = new Instruction1Op() {
        @Override
        public void process() {
            output += p1(false);
        }
    };

    private  final Instruction JNZ = new Instruction2Op() {
        @Override
        public void process() {
            if (p1() != 0) {
                instructionPointer = p2(false) - size();
            }
        }
    };

    private  final Instruction LT = new Instruction3Op() {
        @Override
        public void process() {
            write(p3(true), p1() < p2() ? 1 : 0);
        }
    };

    private  final Instruction EQ = new Instruction3Op() {
        @Override
        public void process() {
            write(p3(true), p1() == p2() ? 1 : 0);
        }
    };

    private  final Instruction JZ = new Instruction2Op() {
        @Override
        public void process() {
            if (p1() == 0) {
                instructionPointer = p2(false) - size();
            }
        }
    };

    private final Instruction HALT = new Instruction() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public void process() {
            halted = true;
        }
    };

    private abstract class Instruction3Op implements Instruction {
        @Override
        public int size() {
            return 4;
        }

        int p1() {
            return mode(100, read(instructionPointer + 1));
        }

        int p2() {
            return mode(1000, read(instructionPointer + 2));
        }

        int p3(boolean out) {
            return out ? read(instructionPointer + 3) : mode(10000, read(instructionPointer + 3));
        }
    }

    private abstract class Instruction2Op implements Instruction {
        @Override
        public int size() {
            return 3;
        }

        int p1() {
            return mode(100, read(instructionPointer + 1));
        }

        int p2(boolean out) {
            return out ? read(instructionPointer + 2) : mode(1000, read(instructionPointer + 2));
        }
    }

    private int mode(int mask, int val) {
        return (opCode() / mask) % 10 == 1 ? val: read(val);
    }

    private abstract class Instruction1Op implements Instruction {
        @Override
        public int size() {
            return 2;
        }

        int p1(boolean out) {
            return out ? read(instructionPointer + 1) : mode( 100, read(instructionPointer + 1));
        }
    };

    private interface Instruction {
        int size();
        void process();
    }
}
