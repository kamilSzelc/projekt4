public class Category {
    private String name;
    private int number;
    private int priority;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return  "\n name: " + name +
                "\n number: " + number +
                ", priority: " + priority;
    }
}
