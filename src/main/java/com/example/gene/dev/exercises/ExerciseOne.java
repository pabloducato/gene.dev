package com.example.gene.dev.exercises;

import com.example.gene.dev.models.Meeting;

import java.util.ArrayList;
import java.util.Comparator;

public class ExerciseOne {

    public void launchFirstTask() {
        int roomId = 0;

        int[] taskIndexArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] startHourArray = {8, 8, 9, 9, 12, 12, 11, 8, 12};
        int[] endHourArray = {10, 11, 11, 11, 14, 13, 13, 11, 13};

        ArrayList<Meeting> meetingArray = new ArrayList<>();

        for (int i = 0; i < taskIndexArray.length; i++) {
            Meeting meeting = new Meeting();
            meeting.setMeetingId(taskIndexArray[i]);
            meeting.setMeetingStartHour(startHourArray[i]);
            meeting.setMeetingEndHour(endHourArray[i]);
            meetingArray.add(meeting);
        }

        System.out.println("Zadanie nr 1\nZajęcia, które należy rozplanować: ");

        for (Meeting meeting : meetingArray) {
            System.out.println("Indeks: " + meeting.getMeetingId() + " -> " + "Godziny: " + meeting.getMeetingStartHour() +
                    " - " + meeting.getMeetingEndHour());
        }

        System.out.println();

        while (meetingArray.size() != 0) {
            maximizeMeetings(meetingArray, roomId);
            roomId++;
        }

        System.out.println("\nMinimalna, wymagana liczba sal, aby obsłużyć podane spotkania wynosi: " + roomId + "\n");
    }

    private void maximizeMeetings(ArrayList<Meeting> meetings, int roomId) {
        meetings.sort(Comparator.comparingInt(Meeting::getMeetingEndHour));

        ArrayList<Meeting> selectedMeetings = new ArrayList<>();
        int currentMeetingEndTime = -1;

        for (Meeting currentMeeting : meetings) {
            if (currentMeeting.getMeetingStartHour() >= currentMeetingEndTime) {
                selectedMeetings.add(currentMeeting);
                currentMeetingEndTime = currentMeeting.getMeetingEndHour();
            }
        }

        System.out.println("Zaplanowane spotkania w sali nr: " + roomId);

        for (Meeting selectedMeeting : selectedMeetings) {
            System.out.println("Indeks: " + selectedMeeting.getMeetingId() + " -> " + "Godziny: " +
                    selectedMeeting.getMeetingStartHour() + " - " + selectedMeeting.getMeetingEndHour());
        }

        meetings.removeAll(selectedMeetings);
    }

}
