package net.tilialacus.adventofcode2019.day02;

public class Interpreter {
    private final int[] mem;
    private int instructionPointer;
    private boolean halted;

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

    public void run() {
        instructionPointer = 0;
        halted = false;
        while (!halted) {
            step();
        }
    }

    protected void step() {
        Instruction instruction;
        switch (read(instructionPointer)) {
            case 1:
                instruction = ADD;
                break;
            case 2:
                instruction = MUL;
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

    private final Instruction ADD = new Instruction3Op() {
        @Override
        public void process() {
            write(p3(), read(p1()) + read(p2()));
        }
    };

    private  final Instruction MUL = new Instruction3Op() {
        @Override
        public void process() {
            write(p3(), read(p1()) * read(p2()));
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
            return read(instructionPointer + 1);
        }

        int p2() {
            return read(instructionPointer + 2);
        }

        int p3() {
            return read(instructionPointer + 3);
        }
    };

    private interface Instruction {
        int size();
        void process();
    }
}
