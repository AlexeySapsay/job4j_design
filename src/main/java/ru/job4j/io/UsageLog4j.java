package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://job4j.ru/profile/exercise/47/task-view/324
 * Оператор плюс (+) для String создает в памяти новую строку. Это плохо, потому что в памяти создаются копии строк.
 * <p>
 * Это приводит к нерациональному использованию памяти.
 * <p>
 * Чтобы избежать сложение строк в slf4j используется шаблон для подстановки переменных.
 * <p>
 * Запишем в лог переменные разных типов.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 14.09.2021
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Alex Sapsay";
        int age = 32;
        LOG.debug("User info name : {}, age: {}", name, age);

        byte javaWorkExperienceAge = 1;
        short placeChanged = 3;
        int salary = 0;
        long expectationSalaryUSDPerNanoSec = 100500L;
        float investPercent = 0.0f;
        double expectationInvestPercent = 0.5d;
        boolean sport = true;
        char gender = 'M';

        LOG.debug("java work experience on stud course : {}, place changed: {}", javaWorkExperienceAge, placeChanged);
        LOG.debug("current salary  : {}, expectation Salary USD Per Nano Sec: {}", salary,
                expectationSalaryUSDPerNanoSec);
        LOG.debug("current salary to investition : {}, goal: {}", investPercent, expectationInvestPercent);
        LOG.debug(" sport : {}, gender : {}", sport, gender);



    }
}
