package Services;

import Entities.ResultFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class GuiService {
    private JFrame frame;
    private JButton loadDataButton;
    private JButton addDoctorButton;
    private JButton addNurseButton;
    private JButton addJanitorButton;
    private JButton addPatientButton;
    private JButton addVictimButton;
    private JButton showDoctorsButton;
    private JButton showNursesButton;
    private JButton showJanitorsButton;
    private JButton showPatientsButton;
    private JButton showVictimsButton;
    private JButton exitButton;

    public GuiService() {
        //  Create the frame and buttons
        frame = new JFrame("Hospital Database");
        loadDataButton = new JButton("Load Data");
        addDoctorButton = new JButton("Add Doctor");
        addNurseButton = new JButton("Add Nurse");
        addJanitorButton = new JButton("Add Janitor");
        addPatientButton = new JButton("Add Patient");
        addVictimButton = new JButton("Add Victim");
        showDoctorsButton = new JButton("Show Doctors");
        showNursesButton = new JButton("Show Nurses");
        showJanitorsButton = new JButton("Show Janitors");
        showPatientsButton = new JButton("Show Patients");
        showVictimsButton = new JButton("Show Victims");
        exitButton = new JButton("Exit Program");

        //  Add elements to the frame
        frame.add(loadDataButton);
        //frame.add(addDoctorButton);
        //frame.add(addNurseButton);
        //frame.add(addJanitorButton);
        //frame.add(addPatientButton);
        //frame.add(addVictimButton);
        frame.add(showDoctorsButton);
        frame.add(showNursesButton);
        frame.add(showJanitorsButton);
        frame.add(showPatientsButton);
        frame.add(showVictimsButton);
        frame.add(exitButton);

        //  Set the frame layout and make it visible
        frame.setLayout(new GridLayout(4, 3));
        frame.setSize(800, 400);
        frame.setVisible(true);

        //  Add event listeners for each button
        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                World world = World.getInstance();
                DatabaseConnection connection = null;
                try {
                    connection = DatabaseConnection.getInstance();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                CountryService countryService = CountryService.getInstance();
                try {
                    countryService.readCountries(world, "data/countries.csv");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                HospitalService hospitalService = HospitalService.getInstance();
                try {
                    hospitalService.readHospitals(world, "data/hospitals.csv");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                DoctorService doctorService = DoctorService.getInstance();
                doctorService.readDoctors(connection, world);

                NurseService nurseService = NurseService.getInstance();
                nurseService.readNurses(connection, world);

                JanitorService janitorService = JanitorService.getInstance();
                janitorService.readJanitors(connection, world);

                PatientService patientService = PatientService.getInstance();
                patientService.readPatients(connection, world);

                VictimService victimService = VictimService.getInstance();
                victimService.readVictims(connection, world);

                new ResultFrame("The data was loaded successfully.");
            }
        });

        showDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String result = getPrintableForm("SELECT * FROM doctors;");
                    new ResultFrame(result);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        showNursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String result = getPrintableForm("SELECT * FROM nurses;");
                    new ResultFrame(result);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        showJanitorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String result = getPrintableForm("SELECT * FROM janitors;");
                    new ResultFrame(result);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        showPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String result = getPrintableForm("SELECT * FROM patients;");
                    new ResultFrame(result);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

        showVictimsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String result = getPrintableForm("SELECT * FROM victims;");
                    new ResultFrame(result);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    private String getPrintableForm(String sqlQuery) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlQuery);
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        String result = "";
        int columnsNumber = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    result += ",  ";
                }
                String columnValue = resultSet.getString(i);
                result += metaData.getColumnName(i) + ": " + columnValue;
            }
            result += "\n";
        }
        return result;
    }


}
