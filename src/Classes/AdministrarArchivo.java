/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import CPUScheduler.Job;
import DataStructures.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author luciano
 */
public class AdministrarArchivo {
    
    public static void SaveProcess  (Job[] jobs, String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            // escribir header
            

            if(file.length() == 0){
                System.out.println("No errors, and file empty");                
                writer.write("Process ID,Arrival Time,Burst Time,Start Time\n");}
            
            // Write each job's data to the CSV file
            for (Job job : jobs) {
                writer.write(
                    job.getProcessID() + "," +
                    job.getArribalTime() + "," +
                    job.getBurstTime() + "," +
                    job.getStartTime() + "\n"
                );
            }
           
            

            System.out.println("Jobs salvados al archivo CSV existosamente! Direccion: " + file.getAbsolutePath() );
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
        }
    
    public static int countProgress(String filePath) { //Contar los jobs/procesos
        int jobCount = 0;

        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("El archivo no existe: " + filePath);
            return 0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (!line.trim().isEmpty()) {
                    jobCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        return jobCount;
    }
    
    
    public static Job[] getJobsFromFile(String filePath, int NumInstructions) {
        // Count the number of jobs in the file
        int jobCount = countProgress(filePath) +NumInstructions;

        // If there are no jobs, return an empty array
        if (jobCount == 0) {
            return new Job[0];
        }

        // Create an array to hold the jobs
        Job[] jobs = new Job[jobCount];
        int index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Split the line into columns using a comma as the delimiter
                String[] columns = line.split(",");

                // Ensure the line has the correct number of columns
                if (columns.length == 4) {
                    String processID = columns[0];
                    long arrivalTime = Long.parseLong(columns[1]);
                    long burstTime = Long.parseLong(columns[2]);
                    long startTime = Long.parseLong(columns[3]);

                    // Create a Job object and add it to the array
                    jobs[index] = new Job(processID, arrivalTime, burstTime, startTime);
                    index++;
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values in the CSV file: " + e.getMessage());
        }

        return jobs;
    }




    
    public static void AddProcess  (Job[] jobs, String filePath) {
        
    }
    
    public static void LoadProcess  (Job[] jobs, String filePath) {
        
    }
}

