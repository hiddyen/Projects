package Project1;

public class IrresponsibleSenderWithDangerousGoods extends Exception{
    public IrresponsibleSenderWithDangerousGoods(){
        System.out.println("IRRESPONSIBLE SENDER !! with container: " + StandardContainer.badSender + "the container was disposed of! at date : " + Time.getDate() + " warning: " + StandardContainer.badSender.warnings  );
    }
}
