import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        List<Interval> list = new ArrayList<>();
        for (int[] ar : arr) {
            list.add(new Interval(ar[0],ar[1]));
        }

        System.out.println(list);
        System.out.println(doMerge(list));
    }


   static List<Interval> doMerge(List<Interval> intervals) {
       List<Interval> merge = new ArrayList<>();
       intervals.sort(Comparator.comparingInt(Interval::getStart));
       System.out.println(intervals);

       merge.add(intervals.get(0));

       intervals.forEach(interval -> {
         Interval lastMerged =  merge.get(merge.size()-1);
         if(interval.getStart() <= lastMerged.getEnd()) {
             lastMerged.setEnd(Integer.max(interval.getEnd(),lastMerged.getEnd()));
         }
         else {
             merge.add(interval);
         }
       });

       return merge;
    }
}

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}