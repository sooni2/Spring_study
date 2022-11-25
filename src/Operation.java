import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("이동수단을 선택해주세요.");
        System.out.println("1. 택시 타기");
        System.out.println("2. 버스 타기");
        System.out.print("선택 >>");

        int option =0;
        option = scanner.nextInt();


        while(true){

            if(option==2){

                Bus bus1 = new Bus(); //새로운 버스 1
                bus1.setNumber("항해99");
                String bus1Number = bus1.getNumber();

                Bus bus2 = new Bus(); //새로운 버스 2
                bus2.setNumber("헤엘666");
                String bus2Number = bus2.getNumber();

                System.out.println("버스 2대 중 선택해주세요.");
                System.out.println("1. 항해99");
                System.out.println("2. 헤엘666");

                int option2 =0;
                option2 = scanner.nextInt();



                if(option2==1){
                        int passnum1 = bus1.getPassengerNow();
                        bus1.setPassengerMax(30);
                        bus1.setStatus("운행중");
                        int pass1 = 2;
                        bus1.boarding(pass1);
                        int passengerNow = bus1.getPassengerNow();
                        System.out.println("잔여 승객 수는 "+ bus1.available(pass1)+"명 입니다.");

                        int busfee1 = bus1.busfee(pass1);
                        System.out.println("버스 요금은 "+busfee1+"원 입니다.");
                    System.out.println();
                    System.out.println();

                    System.out.println("버스 기사가 주유량을 체크합니다.");

                    int gas1 = bus1.setGas(50);
                    bus1.isRunning();

                    System.out.println("버스 기사가 차고지로 향합니다.");
                    bus1.statuschange("차고지행");
                    System.out.println();
                    System.out.println("-----차고지-----");
                    int addgas1 = bus1.addgas(10);
                    System.out.println("주유량이 "+ addgas1+ "로 변했습니다.");

                    bus1.statuschange("운행중");
                    System.out.println();
                    System.out.println("다음 정류장에 도착했습니다.");
                    int pass2 = 45;

                    bus1.boarding(pass2);
                    System.out.println("정원초과여서 정류장을 지나칩니다.");
                    System.out.println();
                    System.out.println("다음 정류장에 도착했습니다.");

                    int pass3 = 5;
                    bus1.boarding(pass3);
                    int now2 = bus1.getPassengerNow();
                    System.out.println(now2);

                    System.out.println("잔여 승객 수는 "+ bus1.available(now2)+"명 입니다.");

                    int busfee2 = bus1.busfee(pass3);

                    System.out.println("버스 요금은 "+busfee2+"원 입니다.");

                    int minusgas = bus1.addgas(-55);
                    System.out.println("주유량이 " + minusgas + "로 변했습니다.");
                    bus1.isRunning();
                    System.out.println(bus1.getStatus());









                    }
                }


            break;

            }


        }


    }

