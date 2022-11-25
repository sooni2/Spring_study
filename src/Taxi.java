public class Taxi extends transport {

    String destination="";
    int basicDistance;
    int distancetoDes;

    int basicfee =3000; //기본요금

    int passengerNow;

    Taxi() {};

    Taxi(
            String number,
            int gas,
            int speed,
            String destination,
            int basicDistance,
            int distancetoDes,
            int fee,
            int basicfee,
            int passengerMax,
            String status,
            int passengerNow

    ){
        this.number =number;
        this.gas = 100;
        this.speed = 0;
        this.destination = destination;
        this.basicDistance =1000;
        this.distancetoDes = distancetoDes;
        this.fee = 1000;
        this.basicfee = basicfee;
        this.status = "일반";
        this.passengerMax = 4;
        this.passengerNow = passengerNow;

    }

    //getter setter


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getBasicDistance() {
        return basicDistance;
    }

    public void setBasicDistance(int basicDistance) {
        this.basicDistance = basicDistance;
    }

    public int getDistancetoDes() {
        return distancetoDes;
    }

    public void setDistancetoDes(int distancetoDes) {
        this.distancetoDes = distancetoDes;
    }

    public int getBasicfee() {
        return basicfee;
    }

    public void setBasicfee(int basicfee) {
        this.basicfee = basicfee;
    }

    public int getPassengerNow() {
        return passengerNow;
    }

    public void setPassengerNow(int passengerNow) {
        this.passengerNow = passengerNow;
    }



    //메서드

    //택시 요금 계산
    public int finalFee(int distancetoDes){
        int finalFee = basicfee+fee*(distancetoDes-basicDistance);
        System.out.println("최종 요금은 "+finalFee+"입니다.");
        return finalFee;
    }

    //탑승 가능 여부
    public boolean boardingcheck(){
        return passengerNow==0;
    }

    //승객수 추가
    public int addPassenger(int addPassenger){
        this.passengerNow += addPassenger;
        return this.passengerNow;
    }

    //승객 탑승
    public int boarding(int passenger){
        while(boardingcheck()){
            if(status.equals("운행")){
                System.out.println("승객"+addPassenger(passenger)+"명이 탑승하였습니다");
                System.out.println("총 탑승승객: "+passengerNow+"명");
                super.setStatus("운행 중");
            }
            break;
        }
        if(!boardingcheck()){
            int overPassenger = (addPassenger(passenger)+passengerNow)-passengerMax;
            System.out.println(overPassenger+"명 초과");
            System.out.println("탑승 불가");
            super.setStatus("탑승 불가");
        }
        return passengerNow;
    }

}
