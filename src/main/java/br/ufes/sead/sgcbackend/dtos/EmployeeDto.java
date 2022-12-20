package br.ufes.sead.sgcbackend.dtos;

public class EmployeeDto {
    private final String cpf;
    private final String name;
    private final Character gender;
    private final String email;

    public EmployeeDto(String cpf, String name, Character gender, String email) {
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

}
