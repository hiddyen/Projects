package Project1;

public class TimeSkip extends Thread{
    @Override
    public void run(){
        System.out.println("Please wait 30 sec for train to departure");
        for(int i=1 ; i<=30; i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }System.out.println("Train has departed!");
        System.out.println("Please wait another 30 sec for another trail to arrive");
        for(int i=1 ; i<=5; i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        } System.out.println("Another train arrived");

    }
}
