package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_getting", nullable = false)
    private LocalDate dateGetting;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_book", nullable = false)
    private Book idBook;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_staff", nullable = false)
    private Staff idStaff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reader", nullable = false)
    private Reader idReader;

    public Reader getIdReader() {
        return idReader;
    }

    public void setIdReader(Reader idReader) {
        this.idReader = idReader;
    }

    public Staff getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Staff idStaff) {
        this.idStaff = idStaff;
    }

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public LocalDate getDateGetting() {
        return dateGetting;
    }

    public void setDateGetting(LocalDate dateGetting) {
        this.dateGetting = dateGetting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}