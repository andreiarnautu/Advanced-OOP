public class Student {
    public String name;
    public int mark;

    public Student() {
        this.name = new String("");
        this.mark = 0;
    }

    public int getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }
}
