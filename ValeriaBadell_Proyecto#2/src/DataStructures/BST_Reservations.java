/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Reservation;

public class BST_Reservations {

    private Reservation pRoot;

    public BST_Reservations() {
        pRoot = null;
    }

    /**
     * @return the pRoot
     */
    public Reservation getpRoot() {
        return pRoot;
    }

    /**
     * @param pRoot the pRoot to set
     */
    public void setpRoot(Reservation pRoot) {
        this.pRoot = pRoot;
    }

    public void newReservation(int id, String name, String lastName, String email, String gender, String hab_type, String phone_number, String Arrival_Date, String Departure_Date) {
        Reservation newReservation = new Reservation(id, name, lastName, email, gender, hab_type, phone_number, Arrival_Date, Departure_Date);
        if (this.getpRoot() != null) {
            this.binaryInsert(newReservation, this.getpRoot());
        } else {

            this.setpRoot(newReservation);
        }
    }

    public Reservation searchReservation(int ci) {
        return this.binarySearch(ci, getpRoot());
    }

    public void deleteReservation(int id) {
        this.setpRoot(binaryDelete(this.getpRoot(), id));
    }

    private void binaryInsert(Reservation newReservation, Reservation actualReservation) {
        if (actualReservation != null) {
            if (actualReservation.getId() >= newReservation.getId()) {
                if (actualReservation.getLeft_son() != null) {
                    this.binaryInsert(newReservation, actualReservation.getLeft_son());
                } else {
                    actualReservation.setLeft_son(newReservation);
                }
            } else if (actualReservation.getId() < newReservation.getId()) {
                if (actualReservation.getRight_son() != null) {
                    this.binaryInsert(newReservation, actualReservation.getRight_son());
                } else {
                    actualReservation.setRight_son(newReservation);
                }
            }
        }
    }

    private Reservation binarySearch(int id, Reservation actualReservation) {
        if (actualReservation != null) {
            Reservation foundedReservation = null;
            if (actualReservation.getId() > id) {
                foundedReservation = this.binarySearch(id, actualReservation.getLeft_son());
            } else if (actualReservation.getId() < id) {
                foundedReservation = this.binarySearch(id, actualReservation.getRight_son());
            } else {
                return actualReservation;
            }
            return foundedReservation;
        }
        return null;
    }

    private Reservation binaryDelete(Reservation actualReservation, int id) {
        if (actualReservation == null) {
            return null;
        }

        if (id < actualReservation.getId()) {

            actualReservation.setLeft_son(binaryDelete(actualReservation.getLeft_son(), id));

        } else if (id > actualReservation.getId()) {

            actualReservation.setRight_son(binaryDelete(actualReservation.getRight_son(), id));

        } else {

            if (actualReservation.getLeft_son() == null && actualReservation.getRight_son() == null) {

                actualReservation = null;

            } else if (actualReservation.getLeft_son() == null) {

                actualReservation = actualReservation.getRight_son();

            } else if (actualReservation.getRight_son() == null) {

                actualReservation = actualReservation.getLeft_son();

            } else {

                Reservation minReservation = min(actualReservation.getRight_son());
                actualReservation.setName(minReservation.getName());
                actualReservation.setLastName(minReservation.getLastName());
                actualReservation.setPhone_number(minReservation.getPhone_number());
                actualReservation.setEmail(minReservation.getEmail());
                actualReservation.setArrival_date(minReservation.getArrival_date());
                actualReservation.setDeparture_date(minReservation.getDeparture_date());
                actualReservation.setGender(minReservation.getGender());
                actualReservation.setId(minReservation.getId());
                actualReservation.setRight_son(binaryDelete(actualReservation.getRight_son(), minReservation.getId()));
            }
        }

        if (actualReservation != null) {

            actualReservation.setHeight(1 + Math.max(branch(actualReservation.getLeft_son()), branch(actualReservation.getRight_son())));

            int balance = branch(actualReservation.getLeft_son()) - branch(actualReservation.getRight_son());

            if (balance > 1 && branch(actualReservation.getLeft_son().getLeft_son()) >= branch(actualReservation.getLeft_son().getRight_son())) {

                actualReservation = rotateRightSon(actualReservation);

            } else if (balance > 1 && branch(actualReservation.getLeft_son().getRight_son()) > branch(actualReservation.getLeft_son().getLeft_son())) {

                actualReservation.setLeft_son(rotateLeftSon(actualReservation.getLeft_son()));
                actualReservation = rotateRightSon(actualReservation);

            } else if (balance < -1 && branch(actualReservation.getRight_son().getRight_son()) >= branch(actualReservation.getRight_son().getLeft_son())) {

                actualReservation = rotateLeftSon(actualReservation);

            } else if (balance < -1 && branch(actualReservation.getRight_son().getLeft_son()) > branch(actualReservation.getRight_son().getRight_son())) {

                actualReservation.setRight_son(rotateRightSon(actualReservation.getRight_son()));
                actualReservation = rotateLeftSon(actualReservation);

            }
        }

        return actualReservation;
    }

    private Reservation min(Reservation actualReservation) {
        if (actualReservation.getLeft_son() == null) {
            return actualReservation;
        }
        return min(actualReservation.getLeft_son());
    }

    private Reservation rotateRightSon(Reservation actualReservation) {
        Reservation left_son = actualReservation.getLeft_son();
        Reservation auxiliarReservation = left_son.getRight_son();

        left_son.setRight_son(actualReservation);
        actualReservation.setLeft_son(auxiliarReservation);

        actualReservation.setHeight(this.max(this.branch(actualReservation.getLeft_son()), this.branch(actualReservation.getRight_son())) + 1);
        left_son.setHeight(this.max(this.branch(left_son.getLeft_son()), this.branch(left_son.getRight_son())) + 1);

        return left_son;
    }

    private Reservation rotateLeftSon(Reservation actualReservation) {
        Reservation right_son = actualReservation.getRight_son();
        Reservation auxiliarReservation = right_son.getLeft_son();

        right_son.setLeft_son(actualReservation);
        actualReservation.setRight_son(auxiliarReservation);

        actualReservation.setHeight(this.max(this.branch(actualReservation.getLeft_son()), this.branch(actualReservation.getRight_son())) + 1);
        right_son.setHeight(this.max(this.branch(right_son.getLeft_son()), this.branch(right_son.getRight_son())) + 1);

        return right_son;
    }

    private int Balance(Reservation actualReservation) {
        if (actualReservation == null) {
            return 0;
        }
        return this.branch(actualReservation.getLeft_son()) - this.branch(actualReservation.getRight_son());
    }

    private int branch(Reservation actualReservation) {
        if (actualReservation == null) {
            return 0;
        }
        return actualReservation.getHeight();
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

}
