// Declare the modules
mod activities;
mod employees;
mod products;
mod roles;

// Declare the structs
pub struct Business {
    name: String,
    address: String,
    activities: Vec<Activities>,
    employees: Vec<Employees>,
    products: Vec<Products>,
    roles: Vec<Roles>,
}

// Implement the services
impl Business {
    pub fn new(name: String, address: String) -> Business {
        Business {
            name,
            address,
            activities: Vec::new(),
            employees: Vec::new(),
            products: Vec::new(),
            roles: Vec::new(),
        }
    }

    pub fn add_activity(&mut self, activity: Activities) {
        self.activities.push(activity);
    }

    pub fn add_employee(&mut self, employee: Employees) {
        self.employees.push(employee);
    }

    pub fn add_product(&mut self, product: Products) {
        self.products.push(product);
    }

    pub fn add_role(&mut self, role: Roles) {
        self.roles.push(role);
    }

    pub fn get_name(&self) -> String {
        self.name.to_string()
    }
}

// Implement the activities module
mod activities {
    pub struct Activities {
        name: String,
    }

    impl Activities {
        pub fn new(name: String) -> Activities {
            Activities { name }
        }

        pub fn get_name(&self) -> String {
            self.name.to_string()
        }
    }
}

// Implement the employees module
mod employees {
    pub struct Employees {
        name: String,
        role: Vec<Roles>,
    }

    impl Employees {
        pub fn new(name: String, role: Vec<Roles>) -> Employees {
            Employees { name, role }
        }

        pub fn get_name(&self) -> String {
            self.name.to_string()
        }

        pub fn get_role(&self) -> Vec<Roles> {
            self.role.clone()
        }
    }
}

// Implement the products module
mod products {
    pub struct Products {
        name: String,
    }

    impl Products {
        pub fn new(name: String) -> Products {
            Products { name }
        }

        pub fn get_name(&self) -> String {
            self.name.to_string()
        }
    }
}

// Implement the roles module
mod roles {
    pub struct Roles {
        name: String,
    }

    impl Roles {
        pub fn new(name: String) -> Roles {
            Roles { name }
        }

        pub fn get_name(&self) -> String {
            self.name.to_string()
        }
    }
}