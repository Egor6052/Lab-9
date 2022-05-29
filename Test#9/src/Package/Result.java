package Package;

import java.util.Comparator;

public class Result {

    private String link;
    private String from;
    private String to;
    private String date;
    private String time;

    public Result(String link, String from, String to, String date, String time) {
        super();
        this.link = link;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
    }

    public Result() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null) ? "<null>" : this.link));
        sb.append(',');
        sb.append("from");
        sb.append('=');
        sb.append(((this.from == null) ? "<null>" : this.from));
        sb.append(',');
        sb.append("to");
        sb.append('=');
        sb.append(((this.to == null) ? "<null>" : this.to));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null) ? "<null>" : this.date));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null) ? "<null>" : this.time));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    //Методы(Компараторы) сортировки по полям

    public static Comparator<Result> byNameAsc = Comparator.comparing(o -> o.link);
    public static Comparator<Result> byNameDesc = (o, o1) -> o1.link.compareTo(o.link);

//    public static Comparator<Result> byFromAsc = Comparator.comparing(o -> o.from);
//    public static Comparator<Result> byFromDesc = (o, o1) -> o1.from.compareTo(o.from);
//
//    public static Comparator<Result> byToAsc = Comparator.comparing(o -> o.to);
//    public static Comparator<Result> byToDesc = (o, o1) -> o1.to.compareTo(o.to);

    public static Comparator<Result> byDateAsc = (o, o1) -> Integer.parseInt(o.date) > Integer.parseInt(o1.date) ? 1 : Integer.parseInt(o.date) < Integer.parseInt(o1.date) ? -1 : 0;
    public static Comparator<Result> byDateDesc = (o, o1) -> Integer.parseInt(o.date) < Integer.parseInt(o1.date) ? 1 : Integer.parseInt(o.date) > Integer.parseInt(o1.date) ? -1 : 0;

    public static Comparator<Result> byTimeAsc = (o, o1) -> Integer.parseInt(o.time) > Integer.parseInt(o1.time) ? 1 : Integer.parseInt(o.time) < Integer.parseInt(o1.time) ? -1 : 0;
    public static Comparator<Result> byTimeDesc = (o, o1) -> Integer.parseInt(o.time) < Integer.parseInt(o1.time) ? 1 : Integer.parseInt(o.time) > Integer.parseInt(o1.time) ? -1 : 0;
}
