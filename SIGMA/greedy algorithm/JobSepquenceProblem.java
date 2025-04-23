
import java.util.*;

public class JobSepquenceProblem {
    /*
     * Given an array of jobs where every job has a deadline and profit if the job
     * is finished before the deadline .it is also give that every job takes a
     * single unit of time , so the minimum possible deadline for any job is 1.
     * Maximize the total profit if only one job can be sheduled at a time
     * 
     * job A -> 4,20
     * job B -> 1,10
     * job C -> 1,40
     * job D -> 1,30
     * 
     * ans -> C, A
     * 
     * Dry run ->
     * A -> 4 time =1 then we can't get another jobs as they 1 dealine it means less
     * than A so we dont have time as we already dont in 1 hour -> profit 20
     * B-> time -> 1 profit 10 A -> time ->2 profit 10+20 -> 30
     * 
     * C-> time -> 1 profit 40 A -> time -> 2 profit 40+20 -> 60
     * 
     * D -> time -> 1 profit 30 A -> time 2 profit 30+20 -> 50
     * 
     * 
     * max prof -> C , A
     * 
     * whats happeing here we cant do jobs of that time we use it to complete the
     * other job i.e if do A first we its deadline is 4hour we did it in 1 hour as
     * already in que then we cant do others as they 1 hour dealine as we already
     * use that one hour
     * to complete the jobs jobDealine > time we have dont to do other tasks
     */

    static class Job {
        int deadLine;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadLine = d;
            profit = p;
        }
    }

    public static void jobSepquenceProblem(int jobInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));// index , deadline , profit

        }
        // sort in the basis of profit
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);// descending order of profit
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        // iterate over the jobs
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadLine > time) {// if deadline is greater than time
                seq.add(curr.id);// add the job
                time++;// increment the time
            }
        }
        System.out.println("max jobs = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.println(seq.get(i));
        }
    }

    public static void main(String[] args) {
        int jonInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        jobSepquenceProblem(jonInfo);
    }
}
