package Package;

import java.util.ArrayList;
import java.util.List;

public class Example {

    private ArrayList<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public Example(ArrayList<Result> cars){
        this.results = cars;
    }

    public void setResult(ArrayList<Result> results) {
        this.results = results;
    }

    public Example(){
        results = new ArrayList<>();
    }

    public void add(Result res) {
        this.results.add(res);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Example.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
