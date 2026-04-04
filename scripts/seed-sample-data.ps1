$ErrorActionPreference = "Stop"

$baseUrl = if ($args.Length -gt 0) { $args[0].TrimEnd("/") } else { "http://localhost:8080" }
$tasksUrl = "$baseUrl/tasks"

$tasks = @(
    '{"title":"Buy groceries","completed":false}',
    '{"title":"Finish Spring Boot API","completed":false}',
    '{"title":"Book dentist appointment","completed":true}',
    '{"title":"Review pull request","completed":false}',
    '{"title":"Plan weekend trip","completed":true}'
)

try {
    curl.exe --silent --show-error --fail "$tasksUrl" | Out-Null
} catch {
    Write-Error "The app is not reachable at $tasksUrl. Start the Spring app first, then run this script again."
}

foreach ($task in $tasks) {
    curl.exe --silent --show-error --fail --json $task "$tasksUrl" | Out-Null
}

Write-Host "Seeded sample tasks to $tasksUrl"
curl.exe --silent --show-error --fail "$tasksUrl"
