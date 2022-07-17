import java.util.Arrays;
public class StepTracker {
    int purposeOfSteps = 1000;

    int[][] monthToData;

    public StepTracker(){
        monthToData = new int[12][30];
    }



    void savingSteps(int month, int day, int steps){
        if(steps > 0) {
            monthToData[month][day] = steps;
        }
    }

    void printStepsPerMonth(int monthStat) {

        for(int i = 0; i < monthToData[monthStat].length; i++){
            if(i > 0) {
                System.out.print(", " + (i + 1) + " день: " + monthToData[monthStat][i]);
            }else{
                System.out.print((i + 1) + " день: " + monthToData[monthStat][i]);
            }
        }
    }

    void changingOfPurpose(int purposeOfStepsNew){
        purposeOfSteps = purposeOfStepsNew;
        System.out.println("Целевое количество шагов изменено. Теперь оно равно " + purposeOfSteps);
    }

    int maxStepsPerDayCalc(int monthStat){
        int maxStepsPerDay = monthToData[monthStat][0];
        for(int l = 1; l < monthToData[monthStat].length; l++) {
            if(maxStepsPerDay < monthToData[monthStat][l]){
                maxStepsPerDay = monthToData[monthStat][l];
            }
        }
        return maxStepsPerDay;
    }

    int sumStepsMonthCalc(int monthStat){
        int monthStepsSum = 0;
        for(int k = 0; k < monthToData[monthStat].length; k++) {
            monthStepsSum += monthToData[monthStat][k];
        }
        return monthStepsSum;
    }

    int bestSeries(int monthStat){
        int serOfMaxSteps = 0;
        int servSeries = 0;
        for(int i = 0; i < monthToData[monthStat].length; i++){
            if(monthToData[monthStat][i] >= purposeOfSteps){
                servSeries++;

                if(i == (monthToData[monthStat].length - 1)){
                    if(serOfMaxSteps < servSeries){
                        serOfMaxSteps = servSeries;
                    }
                }
            }else{
                if(serOfMaxSteps < servSeries){
                    serOfMaxSteps = servSeries;
                }
                servSeries = 0;
            }
        }
        return serOfMaxSteps;
    }

}
