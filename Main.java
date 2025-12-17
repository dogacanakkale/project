// Main.java — Students version
import java.io.*;
import java.util.*;

    public class Main {
        static final int MONTHS = 12;
        static final int DAYS = 28;
        static final int COMMS = 5;
        static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
        static String[] months = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        public static int[][][] profitData=new int[MONTHS][DAYS][COMMS];



        // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
        public static void loadData() {
        }

        // ======== 10 REQUIRED METHODS (Students fill these) ========

        public static String mostProfitableCommodityInMonth(int month) {
            if (month < 0 || month >= MONTHS) {
                return "INVALID_MONTH";
            }
            int maxProfit = Integer.MIN_VALUE;
            String best = "";

            for (int c = 0; c < COMMS; c++) {
                int sum = 0;
                for (int d = 0; d < DAYS; d++)
                    sum += profitData[month][d][c];

                if (sum > maxProfit) {
                    maxProfit = sum;
                    best = commodities[c];
                }
            }
            return best + " " + maxProfit;
        }


        public static int totalProfitOnDay(int month, int day) {
            if (month < 0 || month >= MONTHS || day < 1 || day > DAYS){
                return -99999;}
            int total = 0;
            for (int c = 0; c <COMMS; c++) {
                total += profitData[month][day - 1][c];
            }
            return total;
        }

        public static int commodityProfitInRange(String commodity, int from, int to) {
            int cindex = -1;

            for (int c = 0; c < COMMS; c++) {
                if (commodities[c].equals(commodity)) {
                    cindex = c;
                    break;
                }
            }
            if (cindex == -1 || from < 1 || to > 28 || from > to) {
                return -99999;
            }
            int totalProfit = 0;
            for (int month = 0; month < MONTHS; month++) {
                for (int day = from - 1; day <= to - 1; day++) {
                    totalProfit += profitData[month][day][cindex];
                }
            }
            return totalProfit;
        }

        public static int bestDayOfMonth(int month) {
            if (month < 0 || month >=MONTHS) {
                return -1;
            }
            int bestDay = 1;
            int max = Integer.MIN_VALUE;
            for (int d = 0; d <DAYS; d++) {
                int sum = 0;
                for (int c = 0; c < COMMS; c++) {
                    sum += profitData[month][d][c];
                    if (sum > max) {
                        max = sum;
                        bestDay = d + 1;
                    }
                }
            }

                return bestDay;
            }
        public static String bestMonthForCommodity(String comm) {
                int cIndex = -1;
                for (int c = 0; c < COMMS; c++)
                    if (commodities[c].equals(comm))
                        cIndex = c;

                if (cIndex == -1)
                    return "INVALID_COMMODITY";
                int max = Integer.MIN_VALUE;
                int bestMonth = 0;

                for (int m = 0; m < MONTHS; m++) {
                    int sum = 0;
                    for (int d = 0; d < DAYS; d++){
                        sum += profitData[m][d][cIndex];}
                    if (sum > max) {
                        max = sum;
                        bestMonth = m;
                    }
                }
                return months[bestMonth];
            }


        public static int consecutiveLossDays(String comm) {
            int cIndex = -1;
            for (int c = 0; c < COMMS; c++){
                if (commodities[c].equals(comm)){
                    cIndex = c;
                }
            }
            if (cIndex == -1){
                return -1;
            }

            int maxStreak = 0;
            int current = 0;

            for (int m = 0; m < MONTHS; m++) {
                for (int d = 0; d < DAYS; d++) {
                    if (profitData[m][d][cIndex] < 0) {
                        current++;
                        if (current > maxStreak){
                            maxStreak = current;
                        }

                    } else {
                        current = 0;
                    }
                }
            }
            return maxStreak;
        }

        public static int daysAboveThreshold(String comm, int threshold) {
            int cIndex = -1;
            for (int c = 0; c < COMMS; c++){
                if (commodities[c].equals(comm)){
                    cIndex = c;
                }
            }
            if (cIndex == -1){
                return -1;
            }
            int days = 0;
            for (int m = 0; m < MONTHS; m++)
                for (int d = 0; d < DAYS; d++)
                    if (profitData[m][d][cIndex] > threshold)
                        days++;

            return days;
        }



        public static int biggestDailySwing(int month) {
            if (month < 0 || month >= MONTHS)
                return -99999;

            int maxSwing = 0;
            for (int d = 0; d < DAYS - 1; d++) {

                int today = 0;
                int tomorrow = 0;

                for (int c = 0; c < COMMS; c++) {
                    today += profitData[month][d][c];
                    tomorrow += profitData[month][d + 1][c];
                }

                int diff;
                if (today > tomorrow) {
                    diff = today - tomorrow;
                } else {
                    diff = tomorrow - today;
                }

                if (diff > maxSwing) {
                    maxSwing = diff;
                }
            }
            return maxSwing;

        }

        public static String compareTwoCommodities(String c1, String c2) {
            return "DUMMY is better by 1234";
        }

        public static String bestWeekOfMonth(int month) {
            return "DUMMY";
        }

        public static void main(String[] args) {
            loadData();
            System.out.println("Data loaded – ready for queries");
        }
    }

