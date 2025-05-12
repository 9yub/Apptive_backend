package com.example.apptive_3team.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WeatherDataDTO {
    private LocalDate date;
    private double tempFeelsLike;
    private double tempMin;
    private double tempMax;
    private double tempAvg;
    private double rainAmount;

    public WeatherDataDTO(LocalDate date, double tempFeelsLike, double tempMin, double tempMax, double tempAvg, double rainAmount) {
        this.date = date;
        this.tempFeelsLike = tempFeelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.tempAvg = tempAvg;
        this.rainAmount = rainAmount;
    }
}
