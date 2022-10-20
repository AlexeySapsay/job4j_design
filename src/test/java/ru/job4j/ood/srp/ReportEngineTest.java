package ru.job4j.ood.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.employeesystem.*;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.ood.srp.employeesystem.Constants.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(SYSLIN)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(SYSLIN);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenAccountReport() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(SYSLIN)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append((worker.getSalary() * DOLLARCURENCY
                        - (worker.getSalary() * DOLLARCURENCY * TAX)))
                .append(";")
                .append(SYSLIN);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenITReport() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ITReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<!doctype html>")
                .append("<html lang=\"en\">")
                .append("<head>")
                .append("<meta charset=\"UTF-8\">")
                .append("<title>ITReport</title>")
                .append("</head>")
                .append("<body>")
                .append("Name; Hired; Fired; Salary;")
                .append(SYSLIN)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";")
                .append(SYSLIN)
                .append("</body>")
                .append("</html>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenHRReport() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Innokentiy", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        Report engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(SYSLIN)
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(SYSLIN)
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(SYSLIN);
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenJSONReport() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Gson gson = new GsonBuilder().create();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new JSONReport(store);

        StringBuilder expect = new StringBuilder()
                .append("[{")
                .append("\"name\":").append(gson.toJson(worker.getName())).append(",")
                .append("\"hired\":").append(gson.toJson(worker.getHired())).append(",")
                .append("\"fired\":").append(gson.toJson(worker.getFired())).append(",")
                .append("\"salary\":").append(gson.toJson(worker.getSalary())).append("}]");
        assertThat(engine.generate(employee -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenXMLReport() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new XMLReport(store);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        String expect = String.format("""
                        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                        <employees>
                            <employees>
                                <fired>%s</fired>
                                <hired>%s</hired>
                                <name>%s</name>
                                <salary>%s</salary>
                            </employees>
                        </employees>
                        """,
                date.format(worker.getFired().getTime()),
                date.format(worker.getHired().getTime()),
                worker.getName(),
                worker.getSalary());
        assertThat(engine.generate(employee -> true)).isEqualTo(expect);
    }
}