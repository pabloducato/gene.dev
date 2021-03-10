package com.example.gene.dev.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Meeting {

    private int meetingId;
    private int meetingStartHour;
    private int meetingEndHour;

}
