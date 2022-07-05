package Cwiczenia.Workshop;

import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private List<WorkshopServices> repairs = new ArrayList<>();



    public Receipt wheelRepairService(Car car) {

        for(Wheel wheel : car.getWheels()) {
            if(wheel.isDamaged()){
                wheel.setPressure(3.19);
                wheel.setTireCondition(false);
                repairs.add(WorkshopServices.FLAT_TIRE_FIX);
            } else if (wheel.getPressure() != 3.19) {
                wheel.setPressure(3.19);
            }
        }

        return new Receipt(repairs);
    }

}
