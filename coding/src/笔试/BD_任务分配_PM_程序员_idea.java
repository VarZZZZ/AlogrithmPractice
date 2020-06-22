package 笔试;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BD_任务分配_PM_程序员_idea {
    static class Idea{
        public Idea(int pcId, int proposeTime, int priority, int needTime) {
            this.pcId = pcId;
            this.proposeTime = proposeTime;
            this.priority = priority;
            this.needTime = needTime;
        }
        int pcId;
        int proposeTime;
        int priority;
        int needTime;
        int finish;
    }
    static class Staff{
        FinishEvent peekIdea(Idea idea){
            return new FinishEvent(this,idea);
        }
    }
    static class PM{
        PriorityQueue<Idea> ideaQueue = new PriorityQueue<>((a,b)->{
            if(a.priority!=b.priority) return b.priority-a.priority;
            else if(a.needTime!=b.needTime) return a.needTime-b.needTime;
            else return a.proposeTime-b.proposeTime;
        });
        int id;
        PM(int o) {id=o;}
        IdeaEvent getIdea(Idea idea){
            return new IdeaEvent(this,idea);
        }
    }
    static abstract class Event{
        int time;
        Event(int i) {time=i;};
        abstract void occur();
    }
    static class IdeaEvent extends Event{
        PM pm;
        Idea idea;
        IdeaEvent(PM p,Idea i) {
            super(i.proposeTime);
            pm = p;
            idea = i;
        }
        @Override
        void occur() {
            pmQue.remove(pm);
            pm.ideaQueue.offer(idea);
            pmQue.offer(pm); // offerLast;

            // poll() pollFirst(); pop() removeFirst();

        }
    }
    static  class FinishEvent extends Event{
        Staff st;
        Idea idea;
        FinishEvent(Staff s,Idea i){
            super(i.proposeTime);
            st = s;
            idea = i;
        }
        @Override
        void occur() {
            staffQueue.push(st);
        }
    }
    static PriorityQueue<Event> events = new PriorityQueue<>((e1,e2)->{
        return e1.time-e2.time;
    });
    static PriorityQueue<PM> pmQue = new PriorityQueue<>((p1,p2)->{
        int c1 = p1.ideaQueue.peek().needTime;
        int c2 = p2.ideaQueue.peek().needTime;
        return c1==c2?p1.id-p2.id:c1-c2;
    });
    static ArrayDeque<Staff> staffQueue = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lines;
        lines = sc.nextLine().split(" ");
        int pmCnt = Integer.parseInt(lines[0]);
        int staffCnt = Integer.parseInt(lines[1]);
        Staff[] staffs = new Staff[staffCnt];
        for(int i=0;i<staffCnt;i++){
            staffQueue.push(staffs[i] = new Staff());
        }
        PM[] PMs = new PM[pmCnt];
        for(int i=0;i<pmCnt;i++){
            pmQue.offer(PMs[i] = new PM(i+1));
        }
        int ideaCnt = Integer.parseInt(lines[2]);
        Idea[] ideaArr = new Idea[ideaCnt];
        for(int i=0;i<ideaCnt;i++){
            lines = sc.nextLine().split(" ");
            int pm = Integer.parseInt(lines[0]);
            ideaArr[i] = new Idea(pm,
                    Integer.parseInt(lines[1]),
                    Integer.parseInt(lines[2]),
                    Integer.parseInt(lines[3]));
            events.offer(PMs[pm].getIdea(ideaArr[i]));
        }
        while(!events.isEmpty()){
            int time = events.peek().time;
            
            do{
                events.poll().occur();
            }while (!events.isEmpty()&&events.peek().time==time);
            while(!pmQue.isEmpty()&&!staffQueue.isEmpty()){
                PM pm = pmQue.poll();  // not consider seq thus while
                Staff st = staffQueue.pop(); // removefirst()
                Idea id = pm.ideaQueue.poll();
                id.finish = time+id.needTime;
                events.offer(st.peekIdea(id));
                if(!pm.ideaQueue.isEmpty()) pmQue.offer(pm);
            }
        }

    }

}

