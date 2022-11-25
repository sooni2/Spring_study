public class transport { //상위 클래스 대중교통

    String number; //번호
    int gas = 100; //주유량: 주어진 기본값
    int speed = 0; //속도: 주어진 기본값
    int speedChange; //속도 변경
    String status = ""; //주행 상태
    int passengerMax; //최대 승객 수
    int fee; //요금



    //getter, setter

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getGas(int i) {
        return gas;
    }

    public int setGas(int gas) {
        this.gas = gas;
        return gas;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeedChange() {
        return speedChange;
    }

    public void setSpeedChange(int speedChange) {
        this.speedChange = speedChange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPassengerMax() {
        return passengerMax;
    }

    public void setPassengerMax(int passengerMax) {
        this.passengerMax = passengerMax;
    }

    public int getFee(int now2) {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }



    //메서드

    //운행 시작
    public void start(){
        System.out.println("운행 시작");
    }

    //속도 변경
    public int changeSpeed(int change){
        this.speedChange = change;
        return change;
    }

    //상태 변경
    public String statuschange(String statusChange){
        this.status = statusChange;
        return statusChange;
    }

    //max passenger call
    public int callPassengerMax(){
        return passengerMax;
    }

    //주유 하기
    public int addgas(int addgas){
        return this.gas += addgas;

    }










}

