class SumThread extends Thread {
    private int[] array;
    private int start, end;
    private int partialSum = 0;

    public SumThread(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
        for(int i = start; i < end; i++)
            partialSum += array[i];
    }

    public int getPartialSum(){
        return partialSum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = i + 1;

        int numThreads = 4;
        int chunkSize = numbers.length / numThreads;

        SumThread[] threads = new SumThread[numThreads];

        for(int i = 0; i < numThreads; i++){
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? numbers.length : start + chunkSize;

            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
        }

        int totalSum = 0;
        for (SumThread thread : threads){
            try {
                thread.join();

                int threadResult = thread.getPartialSum();

                System.out.println("현재 쓰레드 합: " + threadResult);

                totalSum += threadResult;
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        System.out.println("총 쓰레드 합: " + totalSum);
    }
}