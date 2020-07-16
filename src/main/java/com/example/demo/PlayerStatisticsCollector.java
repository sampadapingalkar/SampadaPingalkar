
package com.example.demo;

public interface PlayerStatisticsCollector {

    // This is an input. Make note of this player inning.  Runs is a non negative integer.
    void putNewInnings(String player, int runs);

    // Get the runs average(mathematical average) for a player
    double getAverageRuns(String player);

    // Get the total number of innings for the player
    int getInningsCount(String player);
}
