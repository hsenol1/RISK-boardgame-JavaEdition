package src.ConKUeror.domain.controller;


//This interface is created for Observer design pattern.
//BuildMode is publisher and BuildMode Screen is the observer.
public interface BuildModeListener {

    void onBoardIndexEvent(int index);

}
