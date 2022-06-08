package szkolenie

import grails.gorm.transactions.Transactional
import org.jsoup.nodes.Document
import org.jsoup.Jsoup

@Transactional
class FuelCostService {

    static final String FUEL_SERVICE_ADDRESS = "https://www.autocentrum.pl/paliwa/ceny-paliw/"

    def calculateCostByfuelUsage(Double fuelUsage) {
        Document doc = Jsoup.connect(FUEL_SERVICE_ADDRESS).get()
        String priceText = doc.select("div.price").first().text()
        Double price = Double.parseDouble(priceText.split(" ")[0].replace(",",".") )
        return price * fuelUsage


    }
    def calculateCostByModel(String model) {
        if (model == "ford") {
            return  calculateCostByfuelUsage(7.6)
        } else if (model == "vw") {
            return calculateCostByfuelUsage(6.9)
        } else {
            return 0
        }




        }


    }
}
