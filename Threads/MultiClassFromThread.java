class A extends Thread {

public void run() { for (int i=0;i<=5;i++) { System.out.println("Gabber"); } } }

class B extends Thread {

public void run() { for (int i=0;i<=5;i++) { System.out.println("Akshara"); } } }

class C extends Thread {

public void run() { for (int i=0;i<=5;i++) { System.out.println("II - IT"); } } }

class MultiClassFromThread { public static void main(String args[]) { A a = new A(); B b = new B(); C c = new C(); a.start(); b.start(); c.start();

System.out.println(" Hello");

} }