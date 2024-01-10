package com.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

import java.beans.Transient;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* int[] ar={1,2,4,3,5,2,5};
        for(int i:ar)
        {
            System.out.println(i);
        }

        List<Integer> numbers= List.of(1,2,4,3,5,2,5);
        Iterator<Integer> iterator= numbers.iterator();
        while(iterator.hasNext())
        {
            int val= iterator.next();
            System.out.print("  "+val);
        }



        System.out.print(" \n ");
        List<Integer> numbers1= new ArrayList<>();
        numbers1.add(9);
        numbers1.add(6);
        numbers1.add(7);
        numbers1.addAll(Set.of(29,38,54,65));

        numbers1.set(3,2);

        for (int n:numbers1)
        {
            System.out.println(n+" ");

        }
// *********************************************

        Person p1= new Person(1,"Nava");
        Person p2= new Person(1,"Nava");
        System.out.println(p1.equals(p2));



        String s1="nava";
        System.out.println(s1.hashCode());

        Set<String> names= new HashSet<>();
        names.add("Nava1");
        names.add("Nava2");

        names.add(String.valueOf(new Person(1,"Nava")));

        // DEQUE*********************************************

    Deque<Integer> deque=new LinkedList<>();

    deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);


        int t= deque.removeFirst();
        int t1= deque.removeLast();

        System.out.println(deque);


       //MAP//
        Map<String,Integer> scores= new HashMap<>();
        scores.put("Nava",82);
        scores.put("Nava1",83);
        scores.put("Nava2",84);
        scores.put("Nava3",85);

        for(String key: scores.keySet())
        {
            System.out.println(String.format("%s.....%s",key,scores.get(key)));
        }

        for(int val:scores.values())
        {
            System.out.println(val);
        }

        for(Map.Entry<String,Integer>entry: scores.entrySet())
        {
            System.out.println(String.format("%s.....>%s",entry.getKey(),entry.getValue()));
        }







                Path filePath = Path.of("src/hello.txt");

                readCharacter(filePath);
                System.out.println("-----------------------");
                readString(filePath);
                System.out.println("-----------------------");
                readBinary(filePath);

                //  Write operations
                Path writePathCharacter = Path.of("src/char.txt");
                writeCharacter(writePathCharacter, "Hi there!".toCharArray());

                Path writePathString = Path.of("src/string.txt");
                writeString(writePathString, "Hi there!");

                Path writePathBinary = Path.of("src/binary.txt");
                writeBinary(writePathBinary, "Hi there!".getBytes(StandardCharsets.UTF_8));
            }

            static void readCharacter(Path filePath) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
                    int ch;

                    while ((ch = reader.read()) != -1) {
                        System.out.println((char) ch);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            static void readString(Path filePath) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            static void readBinary(Path filePath) {
                try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(filePath.toFile()))) {
                    int ch;

                    while ((ch = stream.read()) != -1) {
                        System.out.println((char) ch);
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


            static void writeCharacter(Path filePath, char[] content) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
//          shorter
                    writer.write(content);

//            verbose
//            for (char c: content) {
//                writer.write(c);
//            }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            static void writeString(Path filePath, String content) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                    writer.write(content);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            static void writeBinary(Path filePath, byte[] content) {
                try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath.toFile()))) {
                    outputStream.write(content);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            */


        List<Employee> employeeList = new ArrayList<>();

        Car car = new Car();
        car.id = 1234;
        car.model = "Toyota Etios";

        employeeList.add(new Employee(1, "Suresh", new Date(), "Mr", car));
        employeeList.add(new Employee(5, "Ramesh", new Date(), "Dr", car));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            objectOutputStream.writeObject(employeeList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            List<Employee> employeeList1 = (List<Employee>) objectInputStream.readObject();

            for (Employee e : employeeList1) {
                System.out.println("Employee > " + e.getTitle() + " " + e.getName() + "; " + e.getDob() + "; CAR > " + e.getCar());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

        class Employee implements Serializable {
            private int id;
            private String name;
            private Date dob;
            public String title;
            private Car car;

            public Car getCar() {
                return car;
            }

            public void setCar(Car car) {
                this.car = car;
            }

            public Employee(int id, String name, Date dob, String title, Car car) {
                this.id = id;
                this.name = name;
                this.dob = dob;
                this.title = title;
                this.car = car;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Date getDob() {
                return dob;
            }

            public void setDob(Date dob) {
                this.dob = dob;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        class Car implements Serializable {
            public int id;
            public String model;
        }




