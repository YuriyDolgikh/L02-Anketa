package biz.itehnika;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "anketaServlet", value = "/anketa")
public class AnketaServlet extends HttpServlet {

    static final String TEMPLATE =
            "<html>" +
            "<head><title>Statistic</title></head>" +
                "<body>" +
                    "<h3>Your info:</h3>" +
                    "<h3>%s</h3>" +
                    "<h3>Statistics for all users: </h3>" +
                    "<h4>%s</h4>" +
                    "<button type=\"button\" name=\"back\" onclick=\"history.back()\">Return</button>" +
                "</body>" +
            "</html>";

    final ArrayList<User> users = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        final String fName = request.getParameter("fName");
        final String lName = request.getParameter("lName");
        final String age = request.getParameter("age");
        final String java = request.getParameter("isJava");
        final String dotNet = request.getParameter("isDotNet");
        final String exp = request.getParameter("whatExperience");

        String thisUser = "Full name is: " + fName + " " + lName + "<br>"+
                "Age = " + age;
        users.add(new User(fName, lName, age, java, dotNet, exp));

        int sumAge = 0;
        int averageAge = 0;
        int numJavaYes = 0;
        int numDotNetYes = 0;
        int numExp0 = 0;
        int numExp2 = 0;
        int numExp5 = 0;

        for (User user : users){
            sumAge += Integer.parseInt(user.getAge());
            if (user.getIsJava().equals("yes")) numJavaYes++;
            if (user.getIsDotNet().equals("yes")) numDotNetYes++;
            if (user.getWhatExperience().equals("0")) numExp0++;
            if (user.getWhatExperience().equals("2")) numExp2++;
            if (user.getWhatExperience().equals("5")) numExp5++;
        }
        averageAge = sumAge / users.size();

        String statistic = "Number of users who like Java = " + numJavaYes + " (" + numJavaYes * 100 / users.size() + "%)<br>" +
                           "Number of users who like .Net = " + numDotNetYes + " (" + numDotNetYes * 100 / users.size() + "%)<br>" +
                           "Users with 0 to 1 year experience = " + numExp0 + " (" + numExp0 * 100 / users.size() + "%)<br>" +
                           "Users with 2 to 4 years experience = " + numExp2 + " (" + numExp2 * 100 / users.size() + "%)<br>" +
                           "Users with 5 and more years experience = " + numExp5 + " (" + numExp5 * 100 / users.size() + "%)<br>" +
                           "Average user age = " + averageAge + "<br>";

        response.getWriter().println(String.format(TEMPLATE, thisUser, statistic));
    }
}
class User{
    private String firstName;
    private String lastName;
    private String age;
    private String isJava;
    private String isDotNet;
    private String whatExperience;

    public User(String firstName, String lastName, String age, String isJava, String isDotNet, String whatExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isJava = isJava;
        this.isDotNet = isDotNet;
        this.whatExperience = whatExperience;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getIsJava() {
        return isJava;
    }

    public String getIsDotNet() {
        return isDotNet;
    }

    public String getWhatExperience() {
        return whatExperience;
    }
}