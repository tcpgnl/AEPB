package com.example.AEPB;

import com.example.AEPB.parkinglot.Car;
import com.example.AEPB.parkinglot.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdvancedParkingLotTest {
    /*
     * 1、
     * given 10个停车场都未停车，ParkingBoy，停放一辆车
     * when 停车
     * then 停车成功并获得车票，确定停到1号停车场
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_ten_empty_parkingLots_and_parking_boy_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 1));
    }

    /*
     * 2、
     * given 10个停车场都未停车，自己将一辆车停1号停车场，
     * when 停车
     * then 停车成功并获得车票，并确定停到1号停车场
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_ten_empty_parkingLots_and_self_parking_No1_parkingLot_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketBySelfParking(car, 1);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 1));
    }

    /*
     * 3、
     * given 10个停车场都停满，ParkingBoy，停放一辆车
     * when 停车
     * then 停车失败抛出异常
     * */
    @Test
    void should_park_car_and_get_ticket_failed_when_parking_car_given_ten_full_parkingLots_and_parking_boy_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        for (int i = 0; i < 500; i++) {
            Car car = new Car();
            parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        }
        Car newCar = new Car();
        Assertions.assertThrows(ParkingLotGroupIsFullException.class, () -> parkingLotGroup.parkingCarAndGetTicketByParkingBoy(newCar));
    }

    /*
     * 4、
     * given 10个停车场都停满，自己停一辆车到1号停车场，
     * when 停车
     * then 停车失败抛出异常
     * */
    @Test
    void should_park_car_and_get_ticket_failed_when_parking_car_given_ten_full_parkingLots_and_self_parking_No1_parkingLot_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        for (int i = 0; i < 500; i++) {
            Car car = new Car();
            parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        }
        Car newCar = new Car();
        Assertions.assertThrows(ParkingLotGroupIsFullException.class, () -> parkingLotGroup.parkingCarAndGetTicketBySelfParking(newCar, 1));
    }

    /*
     * 5、
     * given 10个停车场都未停车，自己停一辆车到2号停车场，
     * when 停车
     * then 停车成功并获得车票，并确定停到2号停车场
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_ten_empty_parkingLots_and_self_parking_No2_parkingLot_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketBySelfParking(car, 2);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 2));
    }

    /*
     * 6、
     * given 1号停车场有一个空位，2号停车场停了一辆车，ParingBoy，停放一辆车
     * when 停车
     * then 停车成功并获得车票，并确定停到1号停车场
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_No1_parkingLot_has_49_cars_and_No2_parkingLot_has_one_car_and_parking_boy_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        for (int i = 0; i < 49; i++) {
            Car no1ParkingLotCar = new Car();
            parkingLotGroup.parkingCarAndGetTicketByParkingBoy(no1ParkingLotCar);
        }
        Car no2ParkingLotCar = new Car();
        parkingLotGroup.parkingCarAndGetTicketBySelfParking(no2ParkingLotCar, 2);
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 1));
    }

    /*
     * 7、
     * given 1号停车场有一个空位，2号停车场停了一辆车，自己停一辆车2号停车场
     * when 停车
     * then 停车成功并获得车票，确定停到2号停车场
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_No1_parkingLot_has_49_cars_and_No2_parkingLot_has_one_car_and_self_parking_No2_parkingLot_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        for (int i = 0; i < 49; i++) {
            Car no1ParkingLotCar = new Car();
            parkingLotGroup.parkingCarAndGetTicketByParkingBoy(no1ParkingLotCar);
        }
        Car no2ParkingLotCar = new Car();
        parkingLotGroup.parkingCarAndGetTicketBySelfParking(no2ParkingLotCar, 2);
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketBySelfParking(car, 2);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 2));
    }

    /*
     * 8、
     * given 1号停车场有一个空位，2号停车场停了一辆车，自己停放一辆车到1号停车场
     * when 停车
     * then 停车成功并获得车票，并确定停到1号停车场
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_No1_parkingLot_has_49_cars_and_No2_parkingLot_has_one_car_and_self_parking_No1_parkingLot_and_one_parking_car() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        for (int i = 0; i < 49; i++) {
            Car no1ParkingLotCar = new Car();
            parkingLotGroup.parkingCarAndGetTicketByParkingBoy(no1ParkingLotCar);
        }
        Car no2ParkingLotCar = new Car();
        parkingLotGroup.parkingCarAndGetTicketBySelfParking(no2ParkingLotCar, 2);
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketBySelfParking(car, 1);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 1));
    }

    /*
     * 9、
     * given 1号停车场停有一辆车，自己使用对应票取1号停车场到对应车
     * when 取车
     * then 取车成功
     * */
    @Test
    void should_get_car_successfully_when_take_the_car_given_No1_parkingLot_has_one_cars_and_self_take_No1_parkingLot_and_one_matched_ticket() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndSelfParking(ticket, 1));
    }

    /*
     * 10、
     * given 1号停车场停有一辆车，自己1号停车场的对应票取2号停车场
     * when 取车
     * then 取车失败并抛异常
     * */
    @Test
    void should_get_car_failed_and_throw_exception_when_take_the_car_given_No1_parkingLot_has_one_cars_and_self_take_No2_parkingLot_and_one_matched_ticket_for_No1_parkingLot() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertThrows(TicketNotFoundCarException.class, () -> parkingLotGroup.getCarByTicketAndSelfParking(ticket, 2));
    }

    /*
     * 11、
     * given 1号停车场停有一辆车，给ParkingBoy对应票
     * when 取车
     * then 取车成功
     * */
    @Test
    void should_get_car_failed_and_throw_exception_when_take_the_car_given_No1_parkingLot_has_one_cars_and_parking_boy_and_one_matched_ticket() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertEquals(car, parkingLotGroup.getCarByTicketAndParkingBoy(ticket));
    }

    /*
     * 12、
     * given 1号停车场停有一辆车，自己无效票取1号停车场
     * when 取车
     * then 取车失败并抛异常
     * */
    @Test
    void should_get_car_failed_and_throw_exception_when_take_the_car_given_No1_parkingLot_has_one_cars_and_self_take_No1_parkingLot_and_one_invalid_ticket() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertThrows(TicketNotFoundCarException.class, () -> parkingLotGroup.getCarByTicketAndSelfParking(null, 1));
    }

    /*
     * 13、
     * given 1号停车场停有一辆车，自己无效票取2号停车场到车
     * when 取车
     * then 取车失败并抛异常
     * */
    @Test
    void should_get_car_failed_and_throw_exception_when_take_the_car_given_No1_parkingLot_has_one_cars_and_self_take_No2_parkingLot_and_one_invalid_ticket() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertThrows(TicketNotFoundCarException.class, () -> parkingLotGroup.getCarByTicketAndSelfParking(null, 2));
    }

    /*
     * 14、
     * given 1号停车场停有一辆车，给ParkingBoy无效票
     * when 取车
     * then 取车失败并抛异常
     * */
    @Test
    void should_get_car_failed_and_throw_exception_when_take_the_car_given_No1_parkingLot_has_one_cars_and_parking_boy_and_one_invalid_ticket() {
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        parkingLotGroup.parkingCarAndGetTicketByParkingBoy(car);
        Assertions.assertThrows(TicketNotFoundCarException.class, () -> parkingLotGroup.getCarByTicketAndParkingBoy(null));
    }

}
