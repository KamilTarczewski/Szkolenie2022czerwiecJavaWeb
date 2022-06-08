package szkolenie

class FuelUsageController {

    FuelCostService fuelCostService

    def index() {
        render "dasasd"
    }

    def drivingPrice() {
        render fuelCostService.calculateCostByModel(params.model)

    }

    def saveNewCar() {
        render fuelCostService.saveNewCar("Focus","Ford","Diesel",6.2,1.6)
        }
    }

    def saveNewCar(String model, String producer,
                   String fuelType, Double fuelConsumption, Double engineVolume) {
        Car car = new Car(model: model,
                producer: producer,
                fuelType: fuelType,
                fuelConsumption: fuelConsumption,
                engineVolume: engineVolume)
        car.save()

    }
}