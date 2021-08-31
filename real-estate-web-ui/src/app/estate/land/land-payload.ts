export interface LandPayload {
    "id": number,
    "estate": {
        "action": string,
        "price": number,
        "decription": string
    },
    "address": {
        "districtMunicipality": string,
        "town": string,
        "microdistrict": string,
        "street": string
    },
    "landArea": number
}