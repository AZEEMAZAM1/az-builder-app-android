# AZ Builder - Professional Construction Services App

A native Android application for professional builder and construction services. Browse services, view details, and book appointments for plumbing, tiling, electrical, painting, roofing, and more.

## Features

- Browse 10+ construction service categories
- Detailed service descriptions with features list
- Service booking with form submission
- About page with contact information (call & email)
- Material Design UI with custom color theme
- Grid layout for service browsing
- ViewBinding for type-safe view access

## Services Offered

xyz

## Tech Stack

- **Language:** Kotlin
- **Min SDK:** 24 (Android 7.0)
- **Target SDK:** 34 (Android 14)
- **UI:** Material Design Components
- **Architecture:** Activity-based with ViewBinding
- **Build System:** Gradle 8.2 with AGP 8.2.0
- **CI/CD:** GitHub Actions (auto-build APK on push)
- **Backend:** Firebase (Firestore, Authentication, Cloud Storage, Cloud Functions)


## Backend (Firebase)

This app uses Firebase as its backend service:

- **Firebase Authentication:** User sign-up, login, and session management
- **Cloud Firestore:** Real-time database for storing service listings, bookings, and user profiles
- **Firebase Cloud Storage:** Image and file storage for service photos and documents
- **Firebase Cloud Functions:** Server-side logic for booking notifications and data processing
- **Firebase Cloud Messaging:** Push notifications for booking confirmations and updates
## Project Structure

```
app/src/main/
  java/com/azbuilder/app/
    MainActivity.kt          - Main screen with service grid
    Service.kt               - Service data class
    ServiceAdapter.kt        - RecyclerView adapter
    ServiceDetailActivity.kt - Service detail page
    BookingActivity.kt       - Booking form
    AboutActivity.kt         - About page with contacts
  res/
    layout/                  - 5 XML layout files
    values/                  - colors, strings, themes
```

## Building

### Prerequisites
- Android Studio or JDK 17+
- Gradle 8.2+

### Build Debug APK
```bash
./gradlew assembleDebug
```

The APK will be at `app/build/outputs/apk/debug/app-debug.apk`

## Download APK

Go to [Actions](../../actions) tab, click the latest successful build, and download the **AZ-Builder-debug-apk** artifact.

## License

MIT License - see LICENSE for details.

## Author

Built by [AZEEMAZAM1](https://github.com/AZEEMAZAM1)
