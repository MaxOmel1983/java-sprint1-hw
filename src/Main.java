import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = 0;
        int day = 0;
        int steps = 0;
        int monthStat = 0;

        StepTracker stepTracker = new StepTracker();

        Converter converter = new Converter(0.75, 0.05);


        while(true){
            printMenu();
            int command = scanner.nextInt();

            if(command == 1){
                while(true) {
                    System.out.println("Введите номер месяца от 0 до 11, в котором Вы хотитете сделать запись:");
                    month = scanner.nextInt();
                    if(month >= 0){
                        if(month < 12){
                            break;
                        }else{
                            System.out.println("Вы ввели слишком большое значение номера месяца. Пожалуйста введите правильное значение.");
                        }
                    }else if(month < 0){
                        System.out.println("Вы ввели отрицательное значение номера месяца. Пожалуйста введите правильное значение.");
                    }
                }

                while(true) {
                    System.out.println("Введите номер дня от 0 до 29, в котором Вы хотитете сделать запись:");
                    day = scanner.nextInt();
                    if(day >= 0){
                        if(day < 30){
                            break;
                        }else{
                            System.out.println("Вы ввели слишком большое значение номера дня. Пожалуйста введите правильное значение.");
                        }
                    }else if(day < 0){
                        System.out.println("Вы ввели отрицательное значение номера дня. Пожалуйста введите правильное значение.");
                    }
                }

                while(true) {
                    System.out.println("Введите количество шагов, которое Вы хотите записать:");
                    steps = scanner.nextInt();
                    if(steps >= 0){
                        break;
                    }
                }

                stepTracker.savingSteps(month, day, steps);



            }else if(command == 2){
                while(true) {
                    System.out.println("Введите номер месяца от 0 до 11, по которому Вы хотитете посмотреть статистику:");
                    monthStat = scanner.nextInt();
                    if(month >= 0){
                        if(month < 12){
                            break;
                        }
                    }
                }


                int monthStepsSum = stepTracker.sumStepsMonthCalc(monthStat);

                stepTracker.printStepsPerMonth(monthStat);

                System.out.println("Общее количество пройденных шагов составило: " + stepTracker.sumStepsMonthCalc(monthStat));

                System.out.println("В этом месяце максимальное количество шагов составило " + stepTracker.maxStepsPerDayCalc(monthStat));

                System.out.println("Среднее количество шагов, сделанных Вами в этом месяце составило "
                        + (int)(monthStepsSum / 30) + " шагов.");

                System.out.println("Вами пройдена дистанция " + converter.caloriesToDistance(monthStepsSum)  + " км.");

                System.out.println("Вами сожжено " + converter.countCalBurned(monthStepsSum) + " килокалорий.");

                System.out.println("Лучшая серия дней, когда Вы достигали целей длилась " + stepTracker.bestSeries(monthStat) + " дней.");


            }else if(command == 3){
                System.out.println("Введите новую цель по количеству шагов в день:");
                int purposeOfStepsNew = scanner.nextInt();
                stepTracker.changingOfPurpose(purposeOfStepsNew);

            }else if(command == 4){
                break;
            }else{
                System.out.println("Такой команды не существует. Попробуйте ввести еще раз.");
            }
        }
    }

    public static void printMenu(){
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день.");
        System.out.println("2 - Напечатать статистику за определенный месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выйти из приложения.");
    }

}
