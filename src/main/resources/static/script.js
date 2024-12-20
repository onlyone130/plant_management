// Add Plant Form Submission
document.getElementById("add-plant-form").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent default form submission

    const plantName = document.getElementById("plant-name").value;
    const scientificName = document.getElementById("scientific-name").value;
    const difficultyLevel = document.getElementById("difficulty-level").value; // 예시: 난이도 선택
    const wateringFrequency = document.getElementById("watering-frequency").value; // 예시: 물 주기 선택

    // Check if plant name is provided
    if (!plantName) {
        alert("Plant name is required.");
        return;
    }

    // Construct the plant data object to send to the server
    const plantData = {
        plantName: plantName,
        scientificName: scientificName,
        difficultyLevel: difficultyLevel, // 서버와 필드명 일치
        wateringFrequency: wateringFrequency // 서버와 필드명 일치
    };

    // Send data to the server
    fetch("http://localhost:9090/plants", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(plantData)
    })
        .then(response => {
            if (response.ok) {
                return response.json(); // 정상적으로 JSON 반환
            } else {
                return response.text().then(text => {
                    throw new Error(text || "Failed to add plant");
                });
            }
        })
        .then(data => {
            alert("Plant added successfully!");
            document.getElementById("add-plant-form").reset();
            fetchAndDisplayPlants(); // Refresh the plant list
        })
        .catch(error => {
            console.error("Error adding plant:", error);
            alert("Failed to add plant: " + error.message);
        });

});
