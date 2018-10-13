/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.util;

import gameclient.view.GamePlayFrm;

/**
 *
 * @author hoang
 */
public class TimeMatch implements Runnable {

    private GamePlayFrm gamePlayFrm;

    public void play(GamePlayFrm gamePlayFrm) {
//        new Runnable() {
//            @Override
//            public void run() {
//                gamePlayFrm.setVisible(true);
//            }
//        }.run();
        gamePlayFrm.setVisible(true);
        Thread time = new Thread(new TimeMatch(gamePlayFrm));
        time.start();
    }

    public TimeMatch(GamePlayFrm gamePlayFrm) {
        this.gamePlayFrm = gamePlayFrm;
    }

    public TimeMatch() {
    }

    @Override
    public void run() {
        runTime();
    }

    public void runTime() {
        int time = Constant.TIME_PLAY;
        while (time > 0) {
            time--;
            gamePlayFrm.setLbTimeLeft(showTime(time));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }
    }

    public static String showTime(int time) {
        int min = time / 60;
        int sec = time % 60;
        if (sec < 10) {
            return "0" + min + ":" + "0" + sec;
        } else {
            return "0" + min + ":" + sec;
        }
    }

}
