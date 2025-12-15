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
        public static int[][][] profitData;



        // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
        public static void loadData() {
        }

        // ======== 10 REQUIRED METHODS (Students fill these) ========

        public static String mostProfitableCommodityInMonth(int month) {
            if (month < 0 || month > 11) {
                return "INVALID_MONTH";
            }
            int[] totalProfits = new int[commodities.length];

            for (int d = 0; d < 28; d++) {
                for (int c = 0; c < commodities.length; c++) {
                    totalProfits[c] += profitData[month][d][c];
                }}
                int maxProfit = totalProfits[0];
                int maxIndex = 0;

                for (int c = 1; c < commodities.length; c++) {
                    if (totalProfits[c] > maxProfit) {
                        maxProfit = totalProfits[c];
                        maxIndex = c;
                    }
                }
                return commodities[maxIndex] + " " + maxProfit;
            }

        public static int totalProfitOnDay(int month, int day) {
            if (day < 1 || day > 28 ){
                return -99999;
            }
            if (month < 0 ||month > 11){
                return -99999;
            }
            int total = 0;
            for (int c = 0; c < commodities.length; c++) {
                total += profitData[month][day - 1][c];
            }
            return total;
        }

        public static int commodityProfitInRange(String commodity, int from, int to) {
            int index = -1;

            for (int i = 0; i < commodities.length; i++) {
                if (commodities[i].equals(commodity)) {
                    index = i;
                    break;
                }
            }
            if (index == -1 || from < 1 || to > 28 || from > to) {
                return -99999;
            }
            int totalProfit = 0;
            for (int month = 0; month < 12; month++) {
                for (int day = from - 1; day <= to - 1; day++) {
                    totalProfit += profitData[month][day][index];
                }
            }
            return totalProfit;
        }

        public static int bestDayOfMonth(int month) {
            if (month < 0 || month > 11) {
                return -1;
            }
            int bestDay = 1;
            int bestProfit = Integer.MIN_VALUE;
            for (int day = 0; day < 28; day++) {
                int sum = 0;
                for (int j = 0; j < COMMS; j++) {
                    sum += profitData[month][day][j];
                    if (sum > bestProfit) {
                        bestProfit = sum;
                        bestDay = day + 1;
                    }
                }
            }
                return bestDay;
            }
        public static String bestMonthForCommodity(String comm) {
            return "DUMMY";
        }

        public static int consecutiveLossDays(String comm) {
            return 1234;
        }

        public static int daysAboveThreshold(String comm, int threshold) {
            return 1234;
        }

        public static int biggestDailySwing(int month) {
            return 1234;
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

