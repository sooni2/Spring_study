public class Bus extends transport{

    int passengerNow=0; //현재 승객 수

    Bus() {}; //기본 생성자 선언



    //getter, setter
    public int getPassengerNow() {
        return passengerNow;
    }

    public int setPassengerNow(int passengerNow) {
        this.passengerNow = passengerNow;
        return passengerNow;
    }



    //승객 탑승 가능 여부
    public boolean boardingcheck(){
        return super.callPassengerMax() >= this.passengerNow;
    }

    //승객수 추가


    //승객 탑승
    public int boarding(int passenger) {
        this.passengerNow += passenger;
        while (boardingcheck()) {

            if (status.equals("운행중")) {

                System.out.println("승객 " + passenger + "명이 탑승하였습니다");
                System.out.println("총 탑승 승객: " + this.passengerNow + "명");
            }
            break;
        }
        if (!boardingcheck()) {
                System.out.println("정원이 초과되었습니다.");
        }
        return this.passengerNow;

        }




    // 잔여 승객 수
    public int available(int passengerNow){
        return super.callPassengerMax()-this.passengerNow;
    }

    //버스 요금
    public int busfee(int passengers){
        return this.fee = (passengers*1000);
    }




    //주유 알람
    //연료가 10이상일때 운행 가능
    boolean leftFuel() {
        return this.gas >= 10;
    }

    boolean isRunning() {

        if(!status.equals("운행중")){  //운행 종료 시 차고지행
            super.setStatus("차고지행");
        }

        if(leftFuel()) {    //운행중 연료 체크
            System.out.println("주유량이 " +this.gas + " 남았습니다." );
            return true;
        }

        if(!leftFuel()) {   //주유량이 떨어지면 차고지행
            System.out.println("주유가 필요합니다.");  //경고메세지
            super.setStatus("차고지행");
        }

        return true;
    }

    //속도 변경
    public int speedChange(int speedChange){
        if(leftFuel()){
            speed += speedChange;
        }
        System.out.println("현재 주행속도는 "+speed+"km/hr 입니다.");
        return speed;
        }











}
