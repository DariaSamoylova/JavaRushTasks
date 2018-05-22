package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    public ArrayList<ArrayList<String>> readFile() {
        File[] allLogs = logDir.toFile().listFiles();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (File currFile : allLogs) {
            if (currFile.toString().endsWith(".log")) {
                try {
                    BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(currFile)));
                    while (true) {
                        String line = r.readLine();
                        if (line == null) break;
                        else {
                            String[] parsedLine = line.split("\t");
                            list.add(new ArrayList<>(Arrays.asList(parsedLine)));
                        }
                    }
                    r.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                if (((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(stroka.get(0));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                if ((currUserStroka.equals(user)) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(stroka.get(0));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currEventStroka = stroka.get(3);
                if (currEventStroka.contains(" "))
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currEventStroka.equals(event.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(stroka.get(0));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currStatusStroka = stroka.get(4);
                if ((currStatusStroka.equals(status.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(stroka.get(0));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> resultSet = new HashSet<>();
        ArrayList<ArrayList<String>> list = readFile();
        for (ArrayList<String> stroka : list) {
            resultSet.add(stroka.get(1));
        }
        //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK

        return resultSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);

                if (((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                if (currEventStroka.contains(" "))
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currUserStroka.equals(user)) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currEventStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currIpStroka = stroka.get(0);
                //if (currEventStroka.contains(" "))
                //    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currIpStroka.equals(ip)) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                //if (currEventStroka.contains(" "))
                //    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currEventStroka.equals(Event.LOGIN.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                //if (currEventStroka.contains(" "))
                //    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currEventStroka.equals(Event.DOWNLOAD_PLUGIN.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                //if (currEventStroka.contains(" "))
                //    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currEventStroka.equals(Event.WRITE_MESSAGE.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                if (currEventStroka.contains(" "))
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currEventStroka.equals(Event.SOLVE_TASK.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals(Event.SOLVE_TASK.name()) && task == currTask) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                if (currEventStroka.contains(" "))
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                if ((currEventStroka.equals(Event.DONE_TASK.name())) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<String> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals(Event.DONE_TASK.name()) && task == currTask) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currUserStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                //  int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    // currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currEventStroka.equals(event.name()) && currUserStroka.equals(user))
                        && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                //  String currUserStroka = stroka.get(1);
                String currStatusStroka = stroka.get(4);
                //  int currTask=0;
                //  if (currEventStroka.contains(" ")) {
                //     currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                // currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                //  }
                if ((currStatusStroka.equals(Status.FAILED.name()))
                        && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                //  String currUserStroka = stroka.get(1);
                String currStatusStroka = stroka.get(4);
                //  int currTask=0;
                //  if (currEventStroka.contains(" ")) {
                //     currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                // currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                //  }
                if ((currStatusStroka.equals(Status.ERROR.name()))
                        && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date resDate = null;
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                //  int currTask=0;
                //  if (currEventStroka.contains(" ")) {
                //     currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                // currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                //  }
                if ((currEventStroka.equals(Event.LOGIN.name()) && currUserStroka.equals(user))
                        && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)
                        && (resDate == null || resDate.after(currStroka))) {
                    //resultSet.add(currStroka);

                    resDate = currStroka;

                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // return Collections.min(resultSet);
        return resDate;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();
        Date resDate = null;
        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals(Event.SOLVE_TASK.name()) && task == currTask && currUserStroka.equals(user)) &&
                        ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)
                        && (resDate == null || resDate.after(currStroka))) {
                    resDate = currStroka;
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resDate;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();
        Date resDate = null;
        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals(Event.DONE_TASK.name()) && task == currTask && currUserStroka.equals(user)) &&
                        ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)
                        && (resDate == null || resDate.after(currStroka))) {
                    resDate = currStroka;
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resDate;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currEventStroka.equals(Event.WRITE_MESSAGE.name()) && currUserStroka.equals(user)) &&
                        ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Date> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currEventStroka.equals(Event.DOWNLOAD_PLUGIN.name()) && currUserStroka.equals(user)) &&
                        ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(currStroka);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Event> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currEventStroka = stroka.get(3);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if (((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(Event.valueOf(currEventStroka));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Event> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currIpStroka.equals(ip)) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(Event.valueOf(currEventStroka));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Event> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currUserStroka.equals(user)) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(Event.valueOf(currEventStroka));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Event> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                String currStatusStroka = stroka.get(4);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currStatusStroka.equals("FAILED")) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(Event.valueOf(currEventStroka));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Set<Event> resultSet = new HashSet<>();

        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                String currUserStroka = stroka.get(1);
                String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                String currStatusStroka = stroka.get(4);
                // int currTask=0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //  currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                }
                if ((currStatusStroka.equals("ERROR")) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    resultSet.add(Event.valueOf(currEventStroka));
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Set<Event> resultSet = new HashSet<>();
        int result = 0;
        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                // String currUserStroka = stroka.get(1);
                //  String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                //   String currStatusStroka = stroka.get(4);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals("SOLVE_TASK")) && currTask == task && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    // resultSet.add(Event.valueOf(currEventStroka));
                    result++;
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Set<Event> resultSet = new HashSet<>();
        int result = 0;
        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                // String currUserStroka = stroka.get(1);
                //  String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                //   String currStatusStroka = stroka.get(4);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals("DONE_TASK")) && currTask == task && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    // resultSet.add(Event.valueOf(currEventStroka));
                    result++;
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Set<Event> resultSet = new HashSet<>();
        int kolvo = 0;
        Map<Integer, Integer> resultMap = new HashMap<>();
        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                // String currUserStroka = stroka.get(1);
                //  String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                //   String currStatusStroka = stroka.get(4);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals("SOLVE_TASK")) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    // resultSet.add(Event.valueOf(currEventStroka));
                    if (resultMap.containsKey(currTask)) {
                        kolvo = resultMap.get(currTask) + 1;
                        resultMap.put(currTask, kolvo);
                    } else
                        resultMap.put(currTask, 1);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        // Set<Event> resultSet = new HashSet<>();
        int kolvo = 0;
        Map<Integer, Integer> resultMap = new HashMap<>();
        try {
            ArrayList<ArrayList<String>> list = readFile();
            for (ArrayList<String> stroka : list) {
                Date currStroka = myFormat.parse(stroka.get(2));
                // String currUserStroka = stroka.get(1);
                //  String currIpStroka = stroka.get(0);
                String currEventStroka = stroka.get(3);
                //   String currStatusStroka = stroka.get(4);
                int currTask = 0;
                if (currEventStroka.contains(" ")) {
                    currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    currTask = Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ') + 1));
                }
                if ((currEventStroka.equals("DONE_TASK")) && ((after != null && currStroka.after(after)) || after == null) && ((before != null && currStroka.before(before)) || before == null)) {
                    // resultSet.add(Event.valueOf(currEventStroka));
                    if (resultMap.containsKey(currTask)) {
                        kolvo = resultMap.get(currTask) + 1;
                        resultMap.put(currTask, kolvo);
                    } else
                        resultMap.put(currTask, 1);
                }

            }
            //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public Set<Object> execute(String query) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String suwnost;
        String field=null;
        String value=null;
        Date date1=null;
        Date date2=null;
        if (query.contains("=")){
              field= query.substring(query.indexOf("for")+4,query.indexOf("=")-1);
            if (query.contains("between")) {
                value = query.substring(query.indexOf("=") + 3, query.indexOf(" and date between") -1);
                try {
                    date1=  myFormat.parse(query.substring(query.indexOf("between") + 9,query.indexOf("\" and \"")));
                    date2= myFormat.parse(query.substring(query.indexOf("\" and \"")+7,query.length()-1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
              else {
                value = query.substring(query.indexOf("=") + 3, query.length() - 1);
            }
            suwnost=query.substring(4,query.indexOf("for")-1);
        } else
            suwnost=query.substring(4);
// and date between "after" and "before"
        Set<Object> resultSet = new HashSet<>();
        ArrayList<ArrayList<String>> list = readFile();
       // SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        switch (suwnost) {

            case "ip":

                try{
                    for (ArrayList<String> stroka : list) {
                       Date currStroka = myFormat.parse(stroka.get(2));
                     String currUserStroka = stroka.get(1);
                    String currIpStroka = stroka.get(0);
                    String currEventStroka = stroka.get(3);
                       String currStatusStroka = stroka.get(4);
                    //  int currTask=0;
                      if (currEventStroka.contains(" ")) {
                        currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                    //      currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                       }

                    if (field!=null) {
                        switch (field) {

                            case "ip":
                                if (currIpStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currIpStroka);
                                break;
                            case "user":
                                if (currUserStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currIpStroka); break;
                            case "date":
                                if (currStroka.equals(myFormat.parse(value))&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currIpStroka); break;
                            case "event":
                                if (currEventStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currIpStroka); break;
                            case "status":
                                if (currStatusStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currIpStroka); break;
                        }
                    } else
                        resultSet.add(currIpStroka);

                }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return resultSet;
            case "user":
               // SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                try{
              //  ArrayList<ArrayList<String>> list = readFile();
                for (ArrayList<String> stroka : list) {
                    Date currStroka = myFormat.parse(stroka.get(2));
                    String currUserStroka = stroka.get(1);
                    String currIpStroka = stroka.get(0);
                    String currEventStroka = stroka.get(3);
                    String currStatusStroka = stroka.get(4);
                    //  int currTask=0;
                    if (currEventStroka.contains(" ")) {
                        currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                        //      currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                    }

                    if (field!=null) {
                        switch (field) {

                            case "ip":
                                if (currIpStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currUserStroka);
                                break;
                            case "user":
                                if (currUserStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currUserStroka); break;
                            case "date":
                                if (currStroka.equals(myFormat.parse(value))&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currUserStroka); break;
                            case "event":
                                if (currEventStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currUserStroka); break;
                            case "status":
                                if (currStatusStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(currUserStroka); break;
                        }
                    } else
                    resultSet.add(currUserStroka);
                } } catch (ParseException e) {
                    e.printStackTrace();
                }
                return resultSet;
            case "date":
             //   ArrayList<ArrayList<String>> list = readFile();
              //  SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
              try{  for (ArrayList<String> stroka : list) {
                  Date currStroka = myFormat.parse(stroka.get(2));
                  String currUserStroka = stroka.get(1);
                  String currIpStroka = stroka.get(0);
                  String currEventStroka = stroka.get(3);
                  String currStatusStroka = stroka.get(4);
                  //  int currTask=0;
                  if (currEventStroka.contains(" ")) {
                      currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                      //      currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                  }

                  if (field!=null) {
                      switch (field) {

                          case "ip":
                              if (currIpStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                  resultSet.add(currStroka);
                              break;
                          case "user":
                              if (currUserStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                  resultSet.add(currStroka); break;
                          case "date":
                              if (currStroka.equals(myFormat.parse(value))&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                  resultSet.add(currStroka); break;
                          case "event":
                              if (currEventStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                  resultSet.add(currStroka); break;
                          case "status":
                              if (currStatusStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                  resultSet.add(currStroka); break;
                      }
                  } else
                    resultSet.add(currStroka);
                }
              } catch (ParseException e) {
                  e.printStackTrace();
              }
                return resultSet;
            case "event":
             //   SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                try{
             //   ArrayList<ArrayList<String>> list = readFile();
                for (ArrayList<String> stroka : list) {
                    Date currStroka = myFormat.parse(stroka.get(2));
                    String currUserStroka = stroka.get(1);
                    String currIpStroka = stroka.get(0);
                    String currEventStroka = stroka.get(3);
                    String currStatusStroka = stroka.get(4);
                    //  int currTask=0;
                    if (currEventStroka.contains(" ")) {
                        currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                        //      currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                    }

                    if (field!=null) {
                        switch (field) {

                            case "ip":
                                if (currIpStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Event.valueOf(currEventStroka));
                                break;
                            case "user":
                                if (currUserStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Event.valueOf(currEventStroka)); break;
                            case "date":
                                if (currStroka.equals(myFormat.parse(value))&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Event.valueOf(currEventStroka)); break;
                            case "event":
                                if (currEventStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Event.valueOf(currEventStroka)); break;
                            case "status":
                                if (currStatusStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Event.valueOf(currEventStroka)); break;
                        }
                    } else
                    resultSet.add(Event.valueOf(currEventStroka));
                } } catch (ParseException e) {
                    e.printStackTrace();
                }
                return resultSet;
            case "status":
             //   SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                try{
            //    ArrayList<ArrayList<String>> list = readFile();
                for (ArrayList<String> stroka : list) {
                    Date currStroka = myFormat.parse(stroka.get(2));
                    String currUserStroka = stroka.get(1);
                    String currIpStroka = stroka.get(0);
                    String currEventStroka = stroka.get(3);
                    String currStatusStroka = stroka.get(4);
                    //  int currTask=0;
                    if (currEventStroka.contains(" ")) {
                        currEventStroka = stroka.get(3).substring(0, (stroka.get(3)).indexOf(' '));
                        //      currTask=Integer.parseInt(stroka.get(3).substring((stroka.get(3)).indexOf(' ')+1));
                    }

                    if (field!=null) {
                        switch (field) {

                            case "ip":
                                if (currIpStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Status.valueOf(currStatusStroka));
                                break;
                            case "user":
                                if (currUserStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Status.valueOf(currStatusStroka)); break;
                            case "date":
                                if (currStroka.equals(myFormat.parse(value))&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Status.valueOf(currStatusStroka)); break;
                            case "event":
                                if (currEventStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Status.valueOf(currStatusStroka)); break;
                            case "status":
                                if (currStatusStroka.equals(value)&&((date1 != null && currStroka.after(date1)) || date1 == null) && ((date2 != null && currStroka.before(date2)) || date2 == null))
                                    resultSet.add(Status.valueOf(currStatusStroka)); break;
                        }
                    } else
                    resultSet.add(Status.valueOf(currStatusStroka));
                } } catch (ParseException e) {
                    e.printStackTrace();
                }
                return resultSet;
        }
        return null;
    }
}
/*3Примеры запросов с параметром:
1) get ip for user = "Vasya"
2) get user for event = "DONE_TASK"
3) get event for date = "03.01.2014 03:45:23"

Общий формат запроса с параметром:
get field1 for field2 = "value1"
Где: field1 - одно из полей: ip, user, date, event или status;
field2 - одно из полей: ip, user, date, event или status;
value1 - значение поля field2.

Алгоритм обработки запроса следующий: просматриваем записи в логе, если поле field2 имеет значение value1, то добавляем поле field1 в множество, которое затем будет возвращено методом execute.

Пример:
Вызов метода execute("get event for date = "30.01.2014 12:56:22″") должен вернуть Set<Event>, содержащий только одно событие SOLVE_TASK. Какая именно задача решалась возвращать не нужно.

Поддержка старого формата запросов должна сохраниться.


Требования:
1. Вызов метода execute с параметром "get ip for user = "[any_user]"" должен возвращать множество уникальных IP адресов, с которых работал пользователь с именем [any_user].
2. Вызов метода execute с параметром "get ip for date = "[any_date]"" должен возвращать множество уникальных IP адресов, события с которых произведены в указанное время [any_date].
3. Вызов метода execute с параметром "get ip for event = "[any_event]"" должен возвращать множество уникальных IP адресов, у которых событие равно [any_event].
4. Вызов метода execute с параметром "get ip for status = "[any_status]"" должен возвращать множество уникальных IP адресов, события с которых закончились со статусом [any_status].
5. Вызов метода execute с параметром "get user for ip = "[any_ip]"" должен возвращать множество уникальных пользователей, которые работали с IP адреса [any_ip].
6. Вызов метода execute с параметром "get user for date = "[any_date]"" должен возвращать множество уникальных пользователей, которые произвели любое действие в указанное время [any_date].
7. Вызов метода execute с параметром "get user for event = "[any_event]"" должен возвращать множество уникальных пользователей, у которых событие равно [any_event].
8. Вызов метода execute с параметром "get user for status = "[any_status]"" должен возвращать множество уникальных пользователей, у которых статус равен [any_status].
9. Вызов метода execute с параметром "get date for ip = "[any_ip]"" должен возвращать множество уникальных дат, за которые с IP адреса [any_ip] произведено любое действие.
10. Вызов метода execute с параметром "get date for user = "[any_user]"" должен возвращать множество уникальных дат, за которые пользователь [any_user] произвел любое действие.
11. Вызов метода execute с параметром "get date for event = "[any_event]"" должен возвращать множество уникальных дат, за которые произошло событие равно [any_event].
12. Вызов метода execute с параметром "get date for status = "[any_status]"" должен возвращать множество уникальных дат, за которые произошло любое событие со статусом [any_status].
13. Вызов метода execute с параметром "get event for ip = "[any_ip]"" должен возвращать множество уникальных событий, которые произошли с IP адреса [any_ip].
14. Вызов метода execute с параметром "get event for user = "[any_user]"" должен возвращать множество уникальных событий, которые произвел пользователь [any_user].
15. Вызов метода execute с параметром "get event for date = "[any_date]"" должен возвращать множество уникальных событий, которые произошли во время [any_date].
16. Вызов метода execute с параметром "get event for status = "[any_status]"" должен возвращать множество уникальных событий, которые завершены со статусом [any_status].
17. Вызов метода execute с параметром "get status for ip = "[any_ip]"" должен возвращать множество уникальных статусов, которые произошли с IP адреса [any_ip].
18. Вызов метода execute с параметром "get status for user = "[any_user]"" должен возвращать множество уникальных статусов, которые произвел пользователь [any_user].
19. Вызов метода execute с параметром "get status for date = "[any_date]"" должен возвращать множество уникальных статусов, которые произошли во время [any_date].
20. Вызов метода execute с параметром "get status for event = "[any_event]"" должен возвращать множество уникальных статусов, у которых событие равно [any_event].
21. Поддержка старого формата запросов должна сохраниться.
*/