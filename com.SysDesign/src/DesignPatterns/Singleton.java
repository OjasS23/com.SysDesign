package DesignPatterns;

public class Singleton {
    // 1 eager loading
    private static final Singleton instance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }

    // lazy loading synchronized
    private static Singleton instance2;

    public static synchronized Singleton getInstance2(){
        if(instance2==null){
            instance2 = new Singleton();
        }
        return instance2;
    }

    //double check
    private static Singleton instance3;
    public static Singleton getInstance3(){
        if(instance3 == null){
            synchronized (Singleton.class){
                instance3 = new Singleton();
            }
        }
        return instance3;
    }

    //static inner class
    private static class Holder{
        private static final Singleton instance4 = new Singleton();
    }

    public static Singleton getInstance4(){
        return Holder.instance4;
    }

}
