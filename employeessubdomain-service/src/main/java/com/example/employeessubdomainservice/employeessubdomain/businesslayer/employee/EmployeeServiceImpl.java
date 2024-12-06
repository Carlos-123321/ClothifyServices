package com.example.employeessubdomainservice.employeessubdomain.businesslayer.employee;


import com.example.employeessubdomainservice.common.EmployeeIdentifier;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.Department;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.DepartmentRepository;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.Address;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.Employee;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.EmployeeRepository;
import com.example.employeessubdomainservice.employeessubdomain.mapperlayer.EmployeeRequestMapper;
import com.example.employeessubdomainservice.employeessubdomain.mapperlayer.EmployeeResponseMapper;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeRequestModel;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeResponseModel;
import com.example.employeessubdomainservice.utils.exceptions.InvalidInputException;
import com.example.employeessubdomainservice.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeRequestMapper employeeRequestMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeResponseMapper employeeResponseMapper, EmployeeRequestMapper employeeRequestMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeResponseMapper = employeeResponseMapper;
        this.employeeRequestMapper = employeeRequestMapper;
    }


    @Override
    public List<EmployeeResponseModel> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseModel> employeeResponseModelList = new ArrayList<>();

        employees.forEach(employee -> {


            Department department = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(employee.getDepartmentIdentifier().getDepartmentId());

            employeeResponseModelList.add(employeeResponseMapper.entityToResponseModel(employee, department));
        });

        return employeeResponseModelList;
    }

    @Override
    public EmployeeResponseModel getEmployeeByEmployeeId(String employeeId) {

        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        if (foundEmployee == null) {
            throw new NotFoundException("Unknown employeeId: " + employeeId);
        }

        Department department = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(foundEmployee.getDepartmentIdentifier().getDepartmentId());

        return employeeResponseMapper.entityToResponseModel(foundEmployee, department);
    }

    @Override
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {

        Department department = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(employeeRequestModel.getDepartmentId());

        if (department == null) {
            throw new InvalidInputException("Unknown departmentId: " + employeeRequestModel.getDepartmentId());
        }

        AtomicBoolean found = new AtomicBoolean(false);
        department.getPositions().forEach(position -> {
            if (Objects.equals(position.getTitle(), employeeRequestModel.getTitle())) {
                found.set(true);
            }
        });

        if (!found.get()) {
            throw new InvalidInputException("Title \"" + employeeRequestModel.getTitle() + "\" not found for the provided department");
        }



        Employee savedEmployee = employeeRepository.save(employeeRequestMapper
            .requestModelToEntity(employeeRequestModel,
                new EmployeeIdentifier(),
                department.getDepartmentIdentifier(),
                new Address(employeeRequestModel.getStreetAddress(), employeeRequestModel.getCity(),
            employeeRequestModel.getProvince(), employeeRequestModel.getCountry(), employeeRequestModel.getPostalCode())));



        return employeeResponseMapper.entityToResponseModel(savedEmployee, department);
    }

    /*
    @Override
    public EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, String employeeId) {

        Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        if (foundEmployee == null) {
            throw new NotFoundException("Unknown employeeId: " + employeeId);
        }

        Department department = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(employeeRequestModel.getDepartmentId());


        if (department == null) {
            throw new InvalidInputException("Unknown departmentId: " + employeeRequestModel.getDepartmentId());
        }

        AtomicBoolean found = new AtomicBoolean(false);
        department.getPositions().forEach(position -> {
            if (Objects.equals(position.getTitle(), employeeRequestModel.getTitle())) {
                found.set(true);
            }
        });

        if (!found.get()) {
            throw new InvalidInputException("Title \"" + employeeRequestModel.getTitle() + "\" not found for the provided department");
        }

        Employee savedEmployee = employeeRepository.save(employeeRequestMapper
            .requestModelToEntity(employeeRequestModel,
                foundEmployee.getEmployeeIdentifier(),
                department.getDepartmentIdentifier(),
                new Address(employeeRequestModel.getStreetAddress(), employeeRequestModel.getCity(),
                    employeeRequestModel.getProvince(), employeeRequestModel.getCountry(), employeeRequestModel.getPostalCode())));


        return employeeResponseMapper.entityToResponseModel(savedEmployee, department);
    }
*/
    @Override
    public EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, String employeeId) {

        Employee existingEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        //check if a customer with the provided UUID exists in the system. If it doesn't, return null
        //later, when we implement exception handling, we'll return an exception
        if (existingEmployee == null) {
            throw new NotFoundException("Unknown employeeId: " + employeeId);
        }

        Department department = departmentRepository.findDepartmentByDepartmentIdentifier_DepartmentId(employeeRequestModel.getDepartmentId());


        if (department == null) {
            throw new InvalidInputException("Unknown departmentId: " + employeeRequestModel.getDepartmentId());
        }

        Address address = new Address(employeeRequestModel.getStreetAddress(), employeeRequestModel.getCity(),
                employeeRequestModel.getProvince(), employeeRequestModel.getCountry(), employeeRequestModel.getPostalCode());
        Employee updatedEmployee = employeeRequestMapper.requestModelToEntity(employeeRequestModel,
                existingEmployee.getEmployeeIdentifier(), existingEmployee.getDepartmentIdentifier(), address);
        updatedEmployee.setId(existingEmployee.getId());

        Employee response = employeeRepository.save(updatedEmployee);
        return employeeResponseMapper.entityToResponseModel(response, department);
    }

    @Override
    public void removeEmployee(String employeeId) {

            Employee foundEmployee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        if (foundEmployee == null) {
            throw new NotFoundException("Unknown employeeId: " + employeeId);
        }

        employeeRepository.delete(foundEmployee);

    }


}
