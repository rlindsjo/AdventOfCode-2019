package net.tilialacus.adventofcode2019.day02;

public class Interpreter {
    private final int[] mem;

    public Interpreter(int[] mem) {
        this.mem = mem;
    }

    public long get(int i) {
        return mem[i];
    }

    public void run() {
        int i = 0;
        while (true) {
            switch (mem[i]) {
                case 1:
                    mem[mem[i + 3]] = mem[mem[i + 1]] + mem[mem[i + 2]];
                    break;
                case 2:
                    mem[mem[i + 3]] = mem[mem[i + 1]] * mem[mem[i + 2]];
                    break;
                case 99:
                    return;
                default:
                    throw new IllegalStateException("Unknown opcode " + mem[i]);
            }
            i += 4;
        }
    }
}
