#  Medical System

Scopul proiectului este de a simula, intr-o mica masura, datele existente intr-un sistem medical, precum medici, infirmiere, ingrijitori, pacienti, spitale si tarile de care apartin.

In structura proiectului exista 11 clase (cu tot cu Main), care sunt prezentate mai jos.

In mare, avem o clasa de serviciu (World), care contine o lista de tari (Country). Fiecare tara contine mai multe spitale, iar in fiecare spital se retin date despre angajati, pacienti si persoane decedate. Functiile implementeaza diverse functionalitati utile intr-un asemenea sistem.

---

### World
1. Este o clasa de serviciu. Rolul sau este de a tine o lista a tarilor existente. Putem adauga si afisa tari, precum si obtine o anumita tara dupa numele acesteia.

---

### Country
1. In cadrul acestei clase tinem numele tarii si o lista sortata alfabetic (folosind TreeSet) a spitalelor existente.
2. Intr-un fel, si aceasta clasa este mai mult sau mai putin una de serviciu, avand ca functionalitati adaugare de spitale si queryuri.

---

### Hospital
1. O clasa care retine urmatoarele date: liste de medici, asistenti, ingrijitori, pacienti si victime (persoane decedate din cauza diverselor boli).
2. Aceasta este clasa cu cele mai multe functionalitati, de la functii care returneaza numarul de doctori sau pacienti pana la functii care returneaza cea mai intalnita boala din spital sau suma totala a salariilor angajatilor spitalului.
3. In principiu, am incercat sa implementez diverse date care ar fi utile si in viata reala, pornind de la listele mentionate mai sus.

---

### HospitalComparator
1. Clasa care implementeaza un comparator pentru clasa Hospital. Sorteaza spitalele alfabetic dupa denumirile lor.

---

### Person
1. Clasa de baza pentru diferitele tipuri de oameni care sunt intalniti in sistemul spitalicesc. Are atribute de baza comune pentru toti, si anume nume si varsta.

---

### Pacient
1. Clasa care retine datele pacientilor dintr-un spital si care extinde clasa *Person*.
2. In aditie fata de aceasta, mai retine si numarul de zile de cand pacientul este internat si o lista de boli de care acesta sufera.

---

### Doctor
1. Clasa care retine datele doctorilor dintr-un spital si care extinde clasa *Person*.
2. In aditie fata de aceasta, retine salariul lunar al doctorului, specializarea acestuia si numarul de pacienti pe care i-a tratat in cariera.

---

### Nurse
1. Clasa care retine datele asistentilor dintr-un spital si care extinde clasa *Person*.
2. In aditie fata de aceasta, retine salariul lunar al asistentului / asistentei si cati ani de experienta are.

---

### Janitor
1. Clasa care retine datele oamenilor de serviciu dintr-un spital si care extinde clasa *Person*.
2. In aditie fata de aceasta, retine salariul lunar al ingrijitorului si schimbul in care lucreaza.

---

### Victim
1. Clasa care retine datele oamenilor decedati in cadrul spitalului si care extinde clasa *Person*.
2. In aditie fata de aceasta, mai retine cauza mortii persoanei decedate.

 