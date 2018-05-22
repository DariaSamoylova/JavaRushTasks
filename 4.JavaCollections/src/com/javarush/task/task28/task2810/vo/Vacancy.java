package com.javarush.task.task28.task2810.vo;

/**
 * Created by mr_ma on 12.03.2018.
 */
public class Vacancy {
    private  String title, salary, city, companyName, siteName, url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;

        Vacancy vacancy = (Vacancy) o;

        if (getTitle() != null ? !getTitle().equals(vacancy.getTitle()) : vacancy.getTitle() != null) return false;
        if (getSalary() != null ? !getSalary().equals(vacancy.getSalary()) : vacancy.getSalary() != null) return false;
        if (getCity() != null ? !getCity().equals(vacancy.getCity()) : vacancy.getCity() != null) return false;
        if (getCompanyName() != null ? !getCompanyName().equals(vacancy.getCompanyName()) : vacancy.getCompanyName() != null)
            return false;
        if (getSiteName() != null ? !getSiteName().equals(vacancy.getSiteName()) : vacancy.getSiteName() != null)
            return false;
        return getUrl() != null ? getUrl().equals(vacancy.getUrl()) : vacancy.getUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getSalary() != null ? getSalary().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getSiteName() != null ? getSiteName().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {

        return title;
    }

    public String getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUrl() {
        return url;
    }
}
