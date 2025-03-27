class DataDosen20 {
    Dosen20[] dataDosen = new Dosen20[10];
    int idx = 0;

    void tambah(Dosen20 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
            System.out.println("-------------------------------");
        }
    }

    void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - 1 - i; j++) {
                if (dataDosen[j].usia > dataDosen[j + 1].usia) {
                    Dosen20 temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j + 1];
                    dataDosen[j + 1] = temp;
                }
            }
        }
    }

    void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[maxIdx].usia) {
                    maxIdx = j;
                }
            }
            Dosen20 temp = dataDosen[i];
            dataDosen[i] = dataDosen[maxIdx];
            dataDosen[maxIdx] = temp;
        }
    }
    void pencarianDataSequential(String nama) {
        boolean ditemukan = false;
        int count = 0;
    
        for (int i = 0; i < idx; i++) {
            if (dataDosen[i].nama.equalsIgnoreCase(nama)) {
                dataDosen[i].tampil();
                System.out.println("-------------------------------");
                ditemukan = true;
                count++;
            }
        }
    
        if (!ditemukan) {
            System.out.println("Data dosen dengan nama \"" + nama + "\" tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("Peringatan: Ditemukan lebih dari satu hasil dengan nama \"" + nama + "\".");
        }
    }
    
    int pencarianDataBinary(int usia, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = (left + right) / 2;
    
        if (dataDosen[mid].usia == usia) {
            return mid;
        } else if (dataDosen[mid].usia > usia) {
            return pencarianDataBinary(usia, left, mid - 1);
        } else {
            return pencarianDataBinary(usia, mid + 1, right);
        }
    }
    
    void cariBerdasarkanUsia(int usia) {
        sortingASC(); // Pastikan data diurutkan ASC sebelum Binary Search
        int pos = pencarianDataBinary(usia, 0, idx - 1);
        boolean ditemukan = false;
        int count = 0;
    
        if (pos != -1) {
            System.out.println("Data dosen dengan usia " + usia + " ditemukan:");
            for (int i = 0; i < idx; i++) {
                if (dataDosen[i].usia == usia) {
                    dataDosen[i].tampil();
                    System.out.println("-------------------------------");
                    ditemukan = true;
                    count++;
                }
            }
        }
    
        if (!ditemukan) {
            System.out.println("Data dosen dengan usia " + usia + " tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("Peringatan: Ditemukan lebih dari satu hasil dengan usia \"" + usia + "\".");
        }
    }
}