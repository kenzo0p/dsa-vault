
import java.util.*;
public class JobSepquenceProblem {
    static class Job {
        int deadLine ;
        int profit;
        int id;

        public Job(int i , int d , int p){
            id = i;
            deadLine = d;
            profit = p;
        }
    }
    public static void jobSepquenceProblem(int jobInfo[][]){
        ArrayList<Job>jobs  = new ArrayList<>();

        for(int i = 0 ;i<jobInfo.length;i++){
            jobs.add( new Job( i, jobInfo[i][0] , jobInfo[i][1])) ;//index , deadline  , profit

        }
        //sort in the basis of profit
        Collections.sort(jobs , (a,b) -> b.profit - a.profit);//descending order of profit
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        //iterate over the jobs
        for(int i = 0;i<jobs.size();i++){
            Job curr  = jobs.get(i);
            if(curr.deadLine > time){//if deadline is greater than time
                seq.add(curr.id);//add the job
                time++;//increment the time
            }
        }
        System.out.println("max jobs = " + seq.size());
        for(int i = 0;i<seq.size();i++){
            System.out.println(seq.get(i));
        }
    }
    public static void main(String[]args){
        int jonInfo[][] = {{4,20} , {1,10} , {1,40} , {1,30}};
        jobSepquenceProblem(jonInfo);
    }
}
