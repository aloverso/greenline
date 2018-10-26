package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/api/v1/stations'
    }
    response {
        status 200
        body '''
		[
            {
              "id": "901N", 
              "name": "Grand Central - 42 St"
            }, 
            {
              "id": "902N", 
              "name": "Times Sq - 42 St"
            }
        ]
	'''
    }
}