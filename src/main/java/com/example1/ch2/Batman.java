package com.example1.ch2;

class Boss{
    private Side_kick robin;

    public synchronized void set_side_kick(Side_kick kid_in_tights) {
        robin = kid_in_tights;
    }

    public synchronized void to_the_bat_cave() {
        robin.get_in_the_car();
    }

    public synchronized void okay() {       // robin으로 호출됨
        // ...
    }

    public synchronized void hold_on() {    // robin으로 호출됨
        // ...
    }
}

// --------------------
class Side_kick {
    private Boss batman;

    public synchronized void set_boss(Boss guy_in_cape) {
        batman = guy_in_cape;
    }

    public synchronized void get_in_the_car() {
        batman.okay();
    }

    public synchronized void sock_bam_pow() {
        batman.hold_on();
    }

}

public class Batman {
    static Boss batman = new Boss();
    static Side_kick robin = new Side_kick();

    public static void main(String[] args) {
        batman.set_side_kick(robin);
        robin.set_boss(batman);

        // ... batman과 robin을 사용하는 일련의 쓰레들을 생성
    }
}